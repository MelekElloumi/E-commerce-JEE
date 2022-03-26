package cartspack;

import java.util.Vector;

public class GestCarts {
	GestCartsDAO dao;
	public GestCarts(){
		dao=new GestCartsDAO();
	}	
	public void add(Cart c){
		dao.addCart(c.getIdUser(), c.getIdProduct(), c.getQuantity());
	}
	public Vector show(int userid){
		return dao.selectAll(userid);
	}
	public void delete(int id) {
		dao.deleteCart(id);
	}
}
