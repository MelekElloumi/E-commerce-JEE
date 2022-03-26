package productspack;

import java.util.Vector;

public class GestProducts { 
	GestProductsDAO dao;
	public GestProducts(){
		dao=new GestProductsDAO();
	}	
	public Product detail(Integer id){
		return dao.loadProduct(id);
	}
	public Vector search(String mc, String sortop){
		return dao.selectSearch(mc,sortop);
	}
	public void add(Product p){
		dao.addProduct(p.getName(), p.getDescription(), p.getQuantity(),p.getPrice());
	}
	public Vector show(){
		return dao.selectAll();
	}
	public void delete(Integer id) {
		dao.deleteProduct(id);
	}
	public void update (Integer id, String name, String description, int quantity,  double price) {
		dao.updateProduct(id,name,description,quantity,price);
	}
}