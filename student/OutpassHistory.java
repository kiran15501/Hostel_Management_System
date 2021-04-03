package student;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

import connect.Database;

public class OutpassHistory extends JFrame {
	
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	JLabel l1,l2,l3,temp;
	
	
	OutpassHistory() {
		
		setLayout(null);
		setTitle("Outpass History");
		l1 = new JLabel("Approved Outpasses");
		l1.setForeground(Color.RED);
		l1.setFont(new Font("Book Antique", Font.BOLD, 20));
		l2 = new JLabel("Denied Outpasses");
		l2.setFont(new Font("Book Antique", Font.BOLD, 20));
		l2.setForeground(Color.RED);
		l3 = new JLabel("Pending Outpasses");
		l3.setFont(new Font("Book Antique", Font.BOLD, 20));
		l3.setForeground(Color.RED);
		setBounds(10, 10, 550, 600);
		try {
			conn = Database.getConnection();
			st = conn.prepareStatement("select reason from outpass where RegisterNo=? and status=1");
			st.setString(1, StudentLogin.s.userName);
			rs = st.executeQuery();
			int i = 1,n = 0;
			l1.setLocation(10, 30*i++);
			l1.setSize(500, 30);
			while(rs.next()) {
				temp = new JLabel(rs.getString(1));
				temp.setFont(new Font("Book Antique", Font.PLAIN, 14));
				temp.setLocation(20, 30*i++);
				temp.setSize(200, 20);
				add(temp);
				n++;
			}
			if(n==0) {
				l1.setText("No New Approved Outpasses");
			}
			l2.setLocation(10, 30*i++);
			l2.setSize(500, 30);
			st = conn.prepareStatement("select reason from outpass where RegisterNo=? and status=0");
			st.setString(1, StudentLogin.s.userName);
			rs = st.executeQuery();
			n = 0;
			while(rs.next()) {
				temp = new JLabel(rs.getString(1));
				temp.setFont(new Font("Book Antique", Font.PLAIN, 14));
				temp.setLocation(20, 30*i++);
				temp.setSize(200, 20);
				add(temp);
				n++;
			}
			if(n==0) {
				l2.setText("No New Denied Outpasses");
			}
			l3.setLocation(10, 30*i++);
			l3.setSize(500, 30);
			st = conn.prepareStatement("select reason from outpass where RegisterNo=? and status=2");
			st.setString(1, StudentLogin.s.userName);
			rs = st.executeQuery();
			n = 0;
			while(rs.next()) {
				temp = new JLabel(rs.getString(1));
				temp.setFont(new Font("Book Antique", Font.PLAIN, 14));
				temp.setLocation(20, 30*i++);
				temp.setSize(200, 20);
				add(temp);
				n++;
			}
			if(n==0) {
				l3.setText("No New Pending Outpasses");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		add(l1);
		add(l2);
		add(l3);
		setVisible(true);
	}
}
