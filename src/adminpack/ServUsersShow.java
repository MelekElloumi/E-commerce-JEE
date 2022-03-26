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


@WebServlet(name="UsersShow", urlPatterns= {"/UsersShow"})
public class ServUsersShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServUsersShow() {
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
            Vector<User> users = job.show();
    		request.setAttribute("users", users);
    		request.getRequestDispatcher("ShowUsers.jsp").forward(request, response);
    		
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

