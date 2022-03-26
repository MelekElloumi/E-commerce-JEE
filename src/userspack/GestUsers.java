package userspack;

import java.util.Vector;


public class GestUsers { 
	GestUsersDAO dao;
	public GestUsers(){
		dao=new GestUsersDAO();
	}	
	public User search(String login, String password){
		return dao.loadUser(login, password);
	}
	public void add(User u){
		dao.addUser(u.getLogin(), u.getEmail(), u.getPassword(),u.getAdmin());
	}
	public Vector show(){
		return dao.selectAll();
	}
	public void delete(Integer id) {
		dao.deleteUser(id);
	}
	public void update (Integer id, String login, String email, String password,  int admin) {
		dao.updateUser(id,login,email,password,admin);
	}
}