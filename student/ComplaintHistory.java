package student;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

import connect.Database;

public class ComplaintHistory extends JFrame {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	JLabel l1,l2,l3,temp;
	
	
	ComplaintHistory() {
		
		setLayout(null);
		setTitle("Complaint History");
		l1 = new JLabel("Checked Complaints");
		l1.setForeground(Color.RED);
		l1.setFont(new Font("Book Antique", Font.BOLD, 20));
		l2 = new JLabel("Unchecked Complaints");
		l2.setFont(new Font("Book Antique", Font.BOLD, 20));
		l2.setForeground(Color.RED);
		setBounds(10, 10, 550, 600);
		try {
			conn = Database.getConnection();
			st = conn.prepareStatement("select complaint from complaints where RegisterNo=? and status=true");
			st.setString(1, StudentLogin.s.userName);
			rs = st.executeQuery();
			int i = 1,n = 0;
			l1.setLocation(10, 30*i++);
			l1.setSize(500, 30);
			while(rs.next()) {
				temp = new JLabel(rs.getString(1));
				temp.setFont(new Font("Book Antique", Font.PLAIN, 14));
				temp.setLocation(20, 30*i++);
				temp.setSize(400, 20);
				add(temp);
				n++;
			}
			if(n==0) {
				l1.setText("No Checked Complaints !");
			}
			l2.setLocation(10, 30*i++);
			l2.setSize(500, 30);
			st = conn.prepareStatement("select complaint from complaints where RegisterNo=? and status=false");
			st.setString(1, StudentLogin.s.userName);
			rs = st.executeQuery();
			n = 0;
			while(rs.next()) {
				temp = new JLabel(rs.getString(1));
				temp.setFont(new Font("Book Antique", Font.PLAIN, 14));
				temp.setLocation(20, 30*i++);
				temp.setSize(400, 20);
				add(temp);
				n++;
			}
			if(n==0) {
				l2.setText("No Unchecked Complaints !");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		add(l1);
		add(l2);
		setVisible(true);
	}
}
