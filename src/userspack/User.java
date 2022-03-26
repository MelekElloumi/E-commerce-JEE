package userspack;

public class User {
	private Integer idUser;
	private String login;
	private String email;
	private String password;
    private int admin;
    
    public Integer getIdUser() { 
    	return idUser;
    }
    public void setIdUser(Integer idUser) { 
    	this.idUser = idUser;
    }
    public int getAdmin() { 
    	return admin;
    }
    public void setAdmin(int admin) { 
    	this.admin = admin;
    }
    public String getLogin() { 
    	return login;
    }
    public void setLogin(String login) { 
    	this.login = login;
    }
    public String getPassword() { 
    	return password;
    }
    public void setPassword(String password) {
    	this.password = password;
    }
    public String getEmail() { 
    	return email;
    }
    public void setEmail(String email) { 
    	this.email = email;
    }
}
