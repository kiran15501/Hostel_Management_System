package admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AdminPanel extends JFrame implements ActionListener{
	String userName,department;
	JButton outpass,complaint,stuDetail,logout;
	JLabel welcome;

    AdminPanel(String userName,String department)
    {
    	this.userName = userName;
    	this.department = department;
        setLayout(null);

        outpass = new JButton("Outpasses");
        outpass.addActionListener(this);
        outpass.setFont(new Font("Book Antique",Font.BOLD,20));
        outpass.setBackground(Color.orange);
        outpass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        outpass.setBounds(40,70,190,30);

        complaint = new JButton("New Complaints");
        complaint.addActionListener(this);
        complaint.setFont(new Font("Book Antique",Font.BOLD,20));
        complaint.setBackground(Color.orange);
        complaint.setCursor(new Cursor(Cursor.HAND_CURSOR));
        complaint.setBounds(260,70,190,30);
        
        stuDetail=new JButton("Student Details");
        stuDetail.addActionListener(this);
        stuDetail.setFont(new Font("Book Antique",Font.BOLD,20));
        stuDetail.setBackground(Color.orange);
        stuDetail.setCursor(new Cursor(Cursor.HAND_CURSOR));
        stuDetail.setBounds(145,140,190,30);
        
        welcome = new JLabel(userName + " Logged in");
        welcome.setFont(new Font("Book Antique",Font.BOLD,14));
        welcome.setBounds(10, 15, 200, 20);
        
        logout = new JButton("Log out");
        logout.setFont(new Font("Book Antique",Font.PLAIN,12));
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.setBounds(400,10,80,20);

        add(outpass);
        add(complaint);
        add(stuDetail);
        add(welcome);
        add(logout);

        setTitle(userName + "\'s Admin Dashboard");
        setBounds(400, 250, 500, 250);
        setBackground(Color.GRAY);
        setResizable(false);
        setVisible(true);
        
        logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AdminLogin.s = null;
				JOptionPane.showMessageDialog(logout,"You have been logged out !");				
			}
		});
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getActionCommand().equals("New Complaints")) Complaint.viewComplaints();   
    	else if(e.getActionCommand().equals("Outpasses")) Outpass.showOutpasses(); 
    	else if(e.getActionCommand().equals("Student Details")) StudentDetailsDashboard.studentDetailsDashboard();
    }       



}
