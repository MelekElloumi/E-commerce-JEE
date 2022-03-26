package dbpack;

import java.sql.Connection;
import java.sql.DriverManager;
public class Database {
	private static Connection conn; 
	static{
		try{ 
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/basetp6","root","");
		}catch(Exception e){ e.printStackTrace();}
    }
	public static Connection getConnection(){ 
		return conn;
	}
	public static void main(String [] args)
	{
		Connection c = Database.getConnection();
	}
}