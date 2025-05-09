package management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    
    JButton submit, reset, close;
    JTextField tfuserName;
    JPasswordField tfpwd;
    
    public Login() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel labuserName = new JLabel("User Name:");
        labuserName.setBounds(20, 20, 100, 20);
        add(labuserName);
        
        tfuserName = new JTextField();
        tfuserName.setBounds(130, 20, 200, 20);
        add(tfuserName);
        
        JLabel labpwd = new JLabel("Password:");
        labpwd.setBounds(20, 60, 100, 20);
        add(labpwd);
        
        tfpwd = new JPasswordField();
        tfpwd.setBounds(130, 60, 200, 20);
        add(tfpwd);
        
        reset = new JButton("Reset");
        reset.setBounds(40, 120, 120, 20);
        reset.addActionListener(this);
        add(reset);
        
        submit = new JButton("Submit");
        submit.setBounds(200, 120, 120, 20);
        submit.addActionListener(this);
        add(submit);
        
        close = new JButton("Close");
        close.setBounds(120, 160, 120, 20);
        close.addActionListener(this);
        add(close);
        
        setSize(800, 500);
        setLocation(800, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Recommended
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            // You can implement login logic here
            String username = tfuserName.getText();
            String password = new String(tfpwd.getPassword());
//            JOptionPane.showMessageDialog(this, "Username: " + username + "\nPassword: " + password);
            
            try {
                Conn c = new Conn();
                
                String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()) {
//                    System.out.println("Valid");

                    new Home();
                    setVisible(false);
                   
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Passwoard");
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == close) {
            setVisible(false);
        } else if (ae.getSource() == reset) {
            tfpwd.setText("");
            tfuserName.setText("");
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
