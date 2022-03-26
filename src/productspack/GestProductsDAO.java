package productspack;

import dbpack.*;
import java.sql.*;
import java.util.Vector; 
public class GestProductsDAO {
	
public Product loadProduct(Integer id){ 
	Connection conn=Database.getConnection();
	Product p=null;
		try {
			PreparedStatement ps=conn.prepareStatement("select * from products where ID_PRODUCT=?");
			ps.setString(1,id.toString()); 
			ResultSet rsProduct=ps.executeQuery(); 
			if(rsProduct.next()) {
				p=new Product();
				p.setIdProduct(new Integer(rsProduct.getInt("ID_PRODUCT")));
				p.setName(rsProduct.getString("NAME"));
				p.setDescription(rsProduct.getString("DESCRIPTION")); 
				p.setQuantity(rsProduct.getInt("QUANTITY"));
				p.setPrice(rsProduct.getDouble("PRICE"));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return p;
}

	public void addProduct(String n,String d, int q, double p){ 
		Connection conn=Database.getConnection(); 
	try {
		PreparedStatement ps=conn.prepareStatement("insert into products (NAME,DESCRIPTION,QUANTITY,PRICE) values(?,?,?,?)");
		ps.setString(1,n);
		ps.setString(2,d);
		ps.setString(3,Integer.toString(q));
		ps.setString(4,Double.toString(p));
		ps.executeUpdate();
	} catch (SQLException e2) { e2.printStackTrace(); }
}
	
	public void updateProduct(Integer id, String n,String d, int q, double p){ 
		Connection conn=Database.getConnection(); 
	try {
		PreparedStatement ps=conn.prepareStatement("update products set NAME=?,DESCRIPTION=?,QUANTITY=?,PRICE=? where ID_PRODUCT=?");
		ps.setString(1,n);
		ps.setString(2,d);
		ps.setString(3,Integer.toString(q));
		ps.setString(4,Double.toString(p));
		ps.setString(5,id.toString());
		ps.executeUpdate();
	} catch (SQLException e2) { e2.printStackTrace(); }
}
	
	public void deleteProduct(Integer id){ 
		Connection conn=Database.getConnection(); 
		Product p=null;
	try {
		PreparedStatement ps=conn.prepareStatement("delete from products where ID_PRODUCT =?");
		ps.setString(1,id.toString());
		ps.executeUpdate();
	} catch (SQLException e2) { e2.printStackTrace(); }
}
	
	public Vector selectAll(){
		Connection conn=Database.getConnection(); 
		Vector products=new Vector();
		Product p=null; try {
			PreparedStatement ps=conn.prepareStatement("select * from products");
			ResultSet rsProduct=ps.executeQuery();
			while(rsProduct.next()){
				p=new Product();
				p.setIdProduct(new Integer(rsProduct.getInt("ID_PRODUCT")));
				p.setName(rsProduct.getString("NAME"));
				p.setDescription(rsProduct.getString("DESCRIPTION")); 
				p.setQuantity(rsProduct.getInt("QUANTITY"));
				p.setPrice(rsProduct.getDouble("PRICE"));
				products.add(p);
			}
		} catch (SQLException e) { e.printStackTrace();
		}
		return products;
	}
	
	public Vector selectSearch( String mc, String sortop){
		Connection conn=Database.getConnection(); 
		Vector products=new Vector();
		Product p=null; try {
			PreparedStatement ps;
			if(sortop.equals("PRICE"))
			ps=conn.prepareStatement("select * from products where UPPER(NAME) LIKE UPPER( ? ) ORDER BY PRICE ");
			else
				ps=conn.prepareStatement("select * from products where UPPER(NAME) LIKE UPPER( ? ) ORDER BY NAME ");
			ps.setString(1,"%"+mc+"%");
			ResultSet rsProduct=ps.executeQuery();
			while(rsProduct.next()){
				p=new Product();
				p.setIdProduct(new Integer(rsProduct.getInt("ID_PRODUCT")));
				p.setName(rsProduct.getString("NAME"));
				p.setDescription(rsProduct.getString("DESCRIPTION")); 
				p.setQuantity(rsProduct.getInt("QUANTITY"));
				p.setPrice(rsProduct.getDouble("PRICE"));
				products.add(p);
			}
		} catch (SQLException e) { e.printStackTrace();
		}
		return products;
	}
}