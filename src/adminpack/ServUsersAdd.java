package adminpack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Vector;
import javax.servlet.http.HttpSession;
import userspack.*;


@WebServlet(name="AddUsers", urlPatterns= {"/AddUsers"})
public class ServUsersAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServUsersAdd() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession maSession = request.getSession(false);
		if(maSession != null){
			User us= (User) maSession.getAttribute("user");
			if (us !=null){
				GestUsers job= new GestUsers();
		        String login=request.getParameter("login");
		        String password=request.getParameter("password");
		        String email=request.getParameter("email");
		        if (login==null || password == null || email == null  ||  login.equals("") ||password.equals("")  ||  email.equals("")) {
					request.setAttribute("messageErr", "One or more fields are empty.");
					request.getRequestDispatcher("AddUsers.jsp").forward(request, response);
					return;
				}
		        int admin=Integer.parseInt(request.getParameter("admin"));
		        User user =new User();
		        user.setEmail(email);
		        user.setLogin(login);
		        user.setPassword(password);
		        user.setAdmin(admin);
		        job.add(user);
				response.sendRedirect("UsersShow");  		
			}
			else {
		           request.setAttribute("messageErr", "Authentification Error");
		           request.getRequestDispatcher("SignIn.jsp").forward(request,response);
			}
      }else {
           request.setAttribute("messageErr", "Please sign in before continuing");
           request.getRequestDispatcher("SignIn.jsp").forward(request,response);		
	}

}
}
