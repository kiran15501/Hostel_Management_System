package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		if(conn != null) return conn;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url, user, password;
			url = "jdbc:mysql://localhost:3306/HMS";
			user = "root";
			password = "123";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
		
	}
	
}