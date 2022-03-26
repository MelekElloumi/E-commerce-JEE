package userspack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="usersignin", urlPatterns= {"/UserSignIn"})
public class ServUserSignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServUserSignIn() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestUsers job= new GestUsers();
        String login=request.getParameter("login");
        String password=request.getParameter("password");
        if (login==null || password == null || login.equals("") ||password.equals("")) {
			request.setAttribute("messageErr", "One or more fields are empty.");
			request.getRequestDispatcher("SignIn.jsp").forward(request, response);
			return;
		}
		User user = job.search(login, password);
		if (user==null) {
			request.setAttribute("messageErr", "User not found.");
			request.getRequestDispatcher("SignIn.jsp").forward(request, response);
		}
		else {
			HttpSession maSession = request.getSession(true);
			maSession.setAttribute("user", user);
			request.setAttribute("user", user);
			request.setAttribute("messageYes", "Logged in successfully");
			if(user.getAdmin()==0)
				request.getRequestDispatcher("UserHome.jsp").forward(request, response);
			else
				request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
