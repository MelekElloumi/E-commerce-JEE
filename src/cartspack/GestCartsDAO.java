package cartspack;

import dbpack.*;
import userspack.User;

import java.sql.*;
import java.util.Vector; 

public class GestCartsDAO {
	public void addCart(int u, int p, int q){ 
		Connection conn=Database.getConnection(); 
	try {
		PreparedStatement ps=conn.prepareStatement("insert into carts (ID_USER,ID_PRODUCT,QUANTITY) values(?,?,?)");
		ps.setString(1,Integer.toString(u));
		ps.setString(2,Integer.toString(p));
		ps.setString(3,Integer.toString(q));
		ps.executeUpdate();
	} catch (SQLException e2) { e2.printStackTrace(); }
}
	public Vector selectAll(int userid){
		Connection conn=Database.getConnection(); 
		Vector carts=new Vector();
		Cart c=null; try {
			PreparedStatement ps=conn.prepareStatement("SELECT carts.*, products.NAME AS PNAME FROM carts, products WHERE (carts.ID_USER= ? ) AND (products.ID_PRODUCT=carts.ID_PRODUCT)");
			ps.setString(1,Integer.toString(userid));
			ResultSet rsCart=ps.executeQuery();
			while(rsCart.next()){
				c=new Cart();
				c.setIdUser(userid);
				c.setNameProduct(rsCart.getString("PNAME"));
				c.setQuantity(rsCart.getInt("carts.QUANTITY")); 
				c.setIdProduct(rsCart.getInt("carts.ID_PRODUCT"));
				c.setIdCart(rsCart.getInt("ID_CART"));
				carts.add(c);
			}
		} catch (SQLException e) { e.printStackTrace();
		}
		return carts;
	}
	
	public void deleteCart(int id){ 
		Connection conn=Database.getConnection(); 
		Cart c=null;
	try {
		PreparedStatement ps=conn.prepareStatement("delete from carts where ID_CART =?");
		ps.setString(1,Integer.toString(id));
		ps.executeUpdate();
	} catch (SQLException e2) { e2.printStackTrace(); }
}
}
