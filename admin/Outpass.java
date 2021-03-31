package admin;

import java.sql.*;
import javax.swing.*;

import connect.Database;

import java.awt.*;
import java.awt.event.*;

public class Outpass {
	JFrame f1;
	JPanel p1;
	static JTextArea t1;
	static JButton b1,b2;
	static JLabel l1,l2,l3,l4;
	static int row=0;
	static int b;
	static Object[][] OutpassArray;
	static Connection conn;
	static PreparedStatement s;
	
	Outpass(){
		try {
			conn = Database.getConnection();
		    s = conn.prepareStatement("select count(*) from Outpass where Status=2 and department=?");
		    s.setString(1, AdminLogin.s.department);
		    ResultSet result = s.executeQuery();
		    result.next();
		    row=0;
		    int n = result.getInt(1);
		    OutpassArray = new Object[n][6];
		    result.close();
		    s = conn.prepareStatement("select Id,RegisterNo,Reason,DateAndTime from Outpass where Status=2 and department=?");
		    s.setString(1, AdminLogin.s.department);
		    ResultSet result1 = s.executeQuery();
		    s = conn.prepareStatement("select name,phone from hostelstudents where registerno=?");
		    while(result1.next()) {
		    	OutpassArray[row][0] = result1.getObject(1);
		    	OutpassArray[row][1] = result1.getObject(2);
		    	OutpassArray[row][2] = result1.getObject(3);
		        OutpassArray[row][3] = result1.getObject(4);
		        s.setString(1, (String)OutpassArray[row][1]);
				result = s.executeQuery();
				if(result.next()) {
					OutpassArray[row][4] = result.getObject(1);
					OutpassArray[row][5] = result.getObject(2);
				}
		        row++;
		    }
		    new OutpassButton(n);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static void showOutpasses() {	
		new Outpass();
	}
	
	static void viewreason(int n) {
		try {
			JFrame f2 = new JFrame(); 
			t1 = new JTextArea();
			l1 = new JLabel("ID : "+OutpassArray[n][0]);
			l2 = new JLabel("REGISTER NUMBER : "+OutpassArray[n][1]);
			l3 = new JLabel("NAME : "+OutpassArray[n][4]);
			l4 = new JLabel("PHONE : "+OutpassArray[n][5]);
			t1.setText((String)OutpassArray[n][2]);
			
			t1.setEditable(false);
			l1.setBounds(20, 20, 400, 20);
			l1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
			l2.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
			l2.setBounds(20, 50, 400, 20);
			l3.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
			l3.setBounds(20, 80, 400, 20);
			l4.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
			l4.setBounds(20, 110, 400, 20);
			
			t1.setBounds(20, 140, 400, 100);
			b1 = new JButton("APPROVE");
			b1.setBounds(100, 270, 100, 20);
			b1.setBackground(Color.orange);
			b1.setForeground(Color.white);
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						s = conn.prepareStatement("update Outpass set Status=1 where id=?");
						s.setInt(1, (int)OutpassArray[n][0]);
						s.executeUpdate();
						b1.setEnabled(false);
						b2.setForeground(Color.orange);
						b2.setEnabled(false);
						row--;
						new Outpass();
					} catch (Exception e1) {
						System.out.println(e1);
					}
				}
		});
		
		
		b2 = new JButton("DENY");
		b2.setBounds(230, 270, 100, 20);
		b2.setBackground(Color.red);
		b2.setForeground(Color.white);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    s = conn.prepareStatement("update Outpass set Status=0 where id=?");
				    s.setInt(1, (int)OutpassArray[n][0]);
					s.executeUpdate();
					b1.setEnabled(false);
					b2.setEnabled(false);
					f2.dispose();
					row--;
					new Outpass();
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});

		
		f2.add(l1);f2.add(l2);f2.add(l3);f2.add(l4);f2.add(t1);f2.add(b1);f2.add(b2);
		f2.setTitle((String)Outpass.OutpassArray[n][4]+"\'s Outpass Request");
		f2.setLayout(null);
		f2.setBounds(100,100,500,350);
		f2.setVisible(true);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}


