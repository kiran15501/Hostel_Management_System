package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ComplaintDescription extends JFrame{
	
	JTextField t1,t3,t4,t5;
	JTextArea t2;
	JLabel l1,l2,l3,l4,l5;
	
		ComplaintDescription(int n) {
			
			setLayout(null);
			setBounds(120, 120, 500, 360);
			setTitle((String)Complaint.complaintTable[n][4]+"\'s Complaint");
			
			t1 = new JTextField((String)Complaint.complaintTable[n][1]);
			t1.setBounds(120, 20, 300, 30);
			t1.setEditable(false);
			t1.setBackground(Color.white);
			l1 = new JLabel("Register No : ");
			l1.setLocation(15, 20);
			l1.setSize(100, 30);
			l1.setFont(new Font("Book Antique",Font.BOLD,14));
			
			t2 = new JTextArea((String)Complaint.complaintTable[n][2]);
			t2.setBounds(120, 70, 300, 60);
			t2.setEditable(false);
			t2.setBackground(Color.white);
			l2 = new JLabel("Complaint : ");
			l2.setLocation(15, 70);
			l2.setSize(100, 30);
			l2.setFont(new Font("Book Antique",Font.BOLD,14));
			
			t3 = new JTextField(Complaint.complaintTable[n][4].toString());
			t3.setBounds(120, 150, 300, 30);
			t3.setEditable(false);
			t3.setBackground(Color.white);
			l3 = new JLabel("Name : ");
			l3.setLocation(15, 150);
			l3.setSize(100, 30);
			l3.setFont(new Font("Book Antique",Font.BOLD,14));
			
			t4 = new JTextField(Complaint.complaintTable[n][5].toString());
			t4.setBounds(120, 200, 300, 30);
			t4.setEditable(false);
			t4.setBackground(Color.white);
			l4 = new JLabel("Phone : ");
			l4.setLocation(15, 200);
			l4.setSize(100, 30);
			l4.setFont(new Font("Book Antique",Font.BOLD,14));
			
			t5 = new JTextField(Complaint.complaintTable[n][3].toString());
			t5.setBounds(120, 250, 300, 30);
			t5.setEditable(false);
			t5.setBackground(Color.white);
			l5 = new JLabel("Date & Time : ");
			l5.setLocation(15, 250);
			l5.setSize(100, 30);
			l5.setFont(new Font("Book Antique",Font.BOLD,14));
			
			add(t1);
			add(t2);
			add(t3);
			add(t4);
			add(t5);
			
			add(l1);
			add(l2);
			add(l3);
			add(l4);
			add(l5);
			
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					dispose();
					Complaint.viewComplaints();
				}
			});
			
			setResizable(false);			
			setVisible(true);
		}
		
}