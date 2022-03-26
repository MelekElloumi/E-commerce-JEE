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


@WebServlet(name="UserUpdate", urlPatterns= {"/UserUpdate"})
public class ServUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServUserUpdate() {
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
				int userid=Integer.parseInt(request.getParameter("userid"));
		        String login=request.getParameter("login");
		        String password=request.getParameter("password");
		        String email=request.getParameter("email");
		        if (login==null || password == null || email == null  ||  login.equals("") ||password.equals("")  ||  email.equals("")) {
					request.setAttribute("messageErr", "One or more fields are empty.");
					request.getRequestDispatcher("UpdateUsers.jsp").forward(request, response);
					return;
				}
		        int admin=Integer.parseInt(request.getParameter("admin"));
		        job.update(userid,login,email,password,admin);
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
