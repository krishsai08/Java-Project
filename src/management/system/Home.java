package management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Home extends JFrame implements ActionListener {
   
    public Home() {
       setLayout(null);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("management/system/icons/front.jpg"));
       
       JLabel image = new JLabel(i1);
       image.setBounds(0,0,1600,900);
       add(image);
       
       JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
       heading.setBounds(500,40,1000,40);
       heading.setForeground(Color.BLUE);
       heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
       
       image.add(heading);
       
       JMenuBar menubar = new JMenuBar();
       setJMenuBar(menubar);
       
       JMenu details = new JMenu("Details");
       menubar.add(details);
       
       JMenuItem flightDetails = new JMenu("Flight Details");
       details.add(flightDetails);
       
       JMenuItem customerDetails = new JMenu("Add Customer Details");
       details.add(customerDetails);
       
       JMenuItem bookFlight = new JMenu("Book Flight");
       details.add(bookFlight);
       
       JMenuItem journeyDetails = new JMenu("Journey Details");
       details.add(journeyDetails);
       
       JMenuItem ticketCancellation = new JMenu("Cancel Ticket");
       details.add(ticketCancellation);
       
       JMenu ticket = new JMenu("Ticket");
       menubar.add(ticket);
       
       JMenuItem boardingPass = new JMenu("Boarding Pass");
       ticket.add(boardingPass);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
    }
    
    public static void main(String[] args) {
        new Home();
    }
}
