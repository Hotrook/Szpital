package Start;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

import java.sql.Connection;

public class Mquery {

	static String polaczenieURL;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	public static void main(){
		 polaczenieURL = "jdbc:mysql://127.0.0.1/szpital?user=test&password=test&useSSL=false";
		 try {
			conn = DriverManager.getConnection(polaczenieURL);
			Class.forName("com.mysql.jdbc.Driver");
			
			stmt = conn.createStatement();
			//ResultSet rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	public Mquery(){
		polaczenieURL = "jdbc:mysql://127.0.0.1/szpital?user=test&password=test&useSSL=false";
		 try {
			conn = DriverManager.getConnection(polaczenieURL);
			Class.forName("com.mysql.jdbc.Driver");
			
			stmt = conn.createStatement();
			//ResultSet rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	public static ResultSet query(String query){
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
		
	}
	
	public static ResultSet update(String query){
		ResultSet rs = null;
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
		
	}
}
