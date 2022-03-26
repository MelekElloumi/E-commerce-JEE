package cartspack;

public class Cart {
	private int idCart;
	private int idUser;
	private int idProduct;
	private int quantity;
	private String nameProduct;
	
	public Cart() {
		nameProduct="ppppppp";
	}
		
    public int getIdUser() { 
    	return idUser;
    }
    public void setIdUser(int idUser) { 
    	this.idUser = idUser;
    }
    
    public int getIdProduct() { 
    	return idProduct;
    }
    public void setIdProduct(int idProduct) { 
    	this.idProduct = idProduct;
    }
    
    public int getIdCart() { 
    	return idCart;
    }
    public void setIdCart(int idCart) { 
    	this.idCart = idCart;
    }
    public int getQuantity() { 
    	return quantity;
    }
    public void setQuantity(int quantity) { 
    	this.quantity = quantity;
    }
    public String getNameProduct() { 
    	return nameProduct;
    }
    public void setNameProduct(String nameProduct) { 
    	this.nameProduct = nameProduct;
    }
}
