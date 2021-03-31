package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.Database;

public class Complaint {
	
	static Object[][] complaintTable;
	static Connection conn;	
	private static PreparedStatement s;
	private static ResultSet r;
	
	static void viewComplaints() {
		conn = Database.getConnection();
		try {
			s = conn.prepareStatement("select count(*) from Complaints where status=0 and department=?");
			s.setString(1, AdminLogin.s.department);
			ResultSet r1 = s.executeQuery();
			r1.next();
			int row = r1.getInt(1);
			r1.close();
			complaintTable = new Object[row][6];
			s = conn.prepareStatement("select Id , RegisterNo , Complaint , DateAndTime from Complaints where status=0 and department=?");
			s.setString(1, AdminLogin.s.department);
			r = s.executeQuery();
			row = 0;
			s = conn.prepareStatement("select name,phone from hostelstudents where registerno=?");
			while(r.next()) {
				complaintTable[row][0] = r.getObject(1);
				complaintTable[row][1] = r.getObject(2);
				complaintTable[row][2] = r.getObject(3);
				complaintTable[row][3] = r.getObject(4);
				s.setString(1, (String)complaintTable[row][1]);
				r1 = s.executeQuery();
				if(r1.next()) {
					complaintTable[row][4] = r1.getObject(1);
					complaintTable[row][5] = r1.getObject(2);
				}
				row++;
			}
			new ComplaintsList(row);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static void describeComplaint(int n) {
		
		try {
			s = conn.prepareStatement("update Complaints set status=true where id=?");
			s.setInt(1,(int)complaintTable[n][0]);
			s.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		new ComplaintDescription(n);
		

	}

}
