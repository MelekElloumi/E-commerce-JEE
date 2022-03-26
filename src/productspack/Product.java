package productspack;

public class Product {
	private Integer idProduct;
	private String name;
	private String description;
	private int quantity;
	private double price;
	
    public Integer getIdProduct() { 
    	return idProduct;
    }
    public void setIdProduct(Integer idProduct) { 
    	this.idProduct = idProduct;
    }
    public int getQuantity() { 
    	return quantity;
    }
    public void setQuantity(int quantity) { 
    	this.quantity = quantity;
    }
    
    public double getPrice() { 
    	return price;
    }
    public void setPrice(double price) { 
    	this.price = price;
    }
    
    public String getName() { 
    	return name;
    }
    public void setName(String name) { 
    	this.name = name;
    }
    
    public String getDescription() { 
    	return description;
    }
    public void setDescription(String description) { 
    	this.description = description;
    }
    
}
