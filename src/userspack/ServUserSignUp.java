package userspack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="usersignup", urlPatterns= {"/UserSignUp"})
public class ServUserSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServUserSignUp() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestUsers job= new GestUsers();
        String login=request.getParameter("login");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        if (login==null || password == null || email == null  ||  login.equals("") ||password.equals("")  ||  email.equals("")) {
			request.setAttribute("messageErr", "One or more fields are empty.");
			request.getRequestDispatcher("SignUp.jsp").forward(request, response);
			return;
		}
        int admin=0;
        User user =new User();
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        user.setAdmin(admin);
        job.add(user);
		HttpSession maSession = request.getSession(true);
		maSession.setAttribute("user", user);
		request.setAttribute("user", user);
		request.setAttribute("messageYes", "Account Created");
		request.getRequestDispatcher("UserHome.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
