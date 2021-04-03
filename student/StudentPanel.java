package student;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class StudentPanel extends JFrame{
	JButton Outpass,Complain,History,logout;
	String userName,department;
	JLabel welcome;

    StudentPanel(String userName,String department)
    {
    	this.userName = userName;
    	this.department = department;
    	setLayout(null);

        Outpass=new JButton("Outpass");
        Outpass.setFont(new Font("Book Antique",Font.BOLD,20));
        Outpass.setBackground(Color.orange);
        Outpass.setForeground(Color.BLACK);
        Outpass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Outpass.setBounds(80,70,130,30);

        Complain=new JButton("Complain");
        Complain.setFont(new Font("Book Antique",Font.BOLD,20));
        Complain.setBackground(Color.orange);
        Complain.setForeground(Color.BLACK);
        Complain.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Complain.setBounds(300,70,130,30);

        History=new JButton("History");
        History.setFont(new Font("Book Antique",Font.BOLD,20));
        History.setBackground(Color.orange);
        History.setForeground(Color.BLACK);
        History.setCursor(new Cursor(Cursor.HAND_CURSOR));
        History.setBounds(180,140,130,30);
        
        logout = new JButton("Log out");
        logout.setFont(new Font("Book Antique",Font.PLAIN,12));
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.setBounds(400,10,80,20);
        
        welcome = new JLabel(userName + " Logged in");
        welcome.setFont(new Font("Book Antique",Font.BOLD,14));
        welcome.setBounds(10, 15, 200, 20);

        add(Outpass);
        add(Complain);
        add(History);
        add(welcome);
        add(logout);

        Outpass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new OutpassRequest();


            }
        });

        Complain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Complaint();
            }
        });

        History.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
                new HistoryDashboard();
            }
        });
        
        logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				StudentLogin.s = null;
				JOptionPane.showMessageDialog(logout,"You have been logged out !");				
			}
		});



        setTitle(userName + "\'s Student Dashboard");
        setLocation(700,400);
        setSize(500,250);
        setBackground(Color.GRAY);
        setForeground(Color.BLACK);
        setResizable(false);
        setVisible(true);


        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

}
