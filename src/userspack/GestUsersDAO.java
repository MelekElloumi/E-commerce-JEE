package userspack;

import dbpack.*;
import java.sql.*;
import java.util.Vector; 
public class GestUsersDAO {
	
public User loadUser(String login, String pass){ 
	Connection conn=Database.getConnection();
	User u=null;
		try {
			PreparedStatement ps=conn.prepareStatement("select * from users where login=? and pass=?");
			ps.setString(1,login); 
			ps.setString(2,pass);
			ResultSet rsUser=ps.executeQuery(); 
			if(rsUser.next()){
				u=new User();
				u.setIdUser(new Integer(rsUser.getInt("ID_USER")));
				u.setLogin(rsUser.getString("LOGIN"));
				u.setPassword(rsUser.getString("PASS"));
				u.setEmail(rsUser.getString("EMAIL"));
				u.setAdmin(rsUser.getInt("IS_ADMIN"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return u;
}

	public void addUser(String l,String e, String p, int a){ 
		Connection conn=Database.getConnection(); 
	try {
		PreparedStatement ps=conn.prepareStatement("insert into users (LOGIN,EMAIL,PASS,IS_ADMIN) values(?,?,?,?)");
		ps.setString(1,l);
		ps.setString(2,e);
		ps.setString(3,p);
		ps.setString(4,Integer.toString(a));
		ps.executeUpdate();
	} catch (SQLException e2) { e2.printStackTrace(); }
}
	
	public void updateUser(Integer id, String l,String e, String p,int a){ 
		Connection conn=Database.getConnection(); 
	try {
		PreparedStatement ps=conn.prepareStatement("update users set LOGIN=?,EMAIL=?,PASS=?,IS_ADMIN=? where ID_USER=?");
		ps.setString(1,l);
		ps.setString(2,e);
		ps.setString(3,p);
		ps.setString(4,Integer.toString(a));
		ps.setString(5,id.toString());
		ps.executeUpdate();
	} catch (SQLException e2) { e2.printStackTrace(); }
}
	
	public void deleteUser(Integer id){ 
		Connection conn=Database.getConnection(); 
		User u=null;
	try {
		PreparedStatement ps=conn.prepareStatement("delete from users where ID_USER =?");
		ps.setString(1,id.toString());
		ps.executeUpdate();
	} catch (SQLException e2) { e2.printStackTrace(); }
}
	
	public Vector selectAll(){
		Connection conn=Database.getConnection(); 
		Vector users=new Vector();
		User u=null; try {
			PreparedStatement ps=conn.prepareStatement("select * from users");
			ResultSet rsUser=ps.executeQuery();
			while(rsUser.next()){
				u=new User();
				u.setIdUser(new Integer(rsUser.getInt("ID_USER")));
				u.setLogin(rsUser.getString("LOGIN"));
				u.setPassword(rsUser.getString("PASS")); 
				u.setEmail(rsUser.getString("EMAIL"));
				u.setAdmin(rsUser.getInt("IS_ADMIN"));
				users.add(u);
			}
		} catch (SQLException e) { e.printStackTrace();
		}
		return users;
	}
}
