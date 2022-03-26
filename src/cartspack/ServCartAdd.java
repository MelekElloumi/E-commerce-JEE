package cartspack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Vector;
import javax.servlet.http.HttpSession;
import userspack.*;


@WebServlet(name="AddCart", urlPatterns= {"/AddCart"})
public class ServCartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServCartAdd() {
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
				GestCarts job= new GestCarts();
		        if (request.getParameter("quantity")==null || request.getParameter("userid") == null || request.getParameter("productid") == null  ||  request.getParameter("userid").equals("") ||request.getParameter("userid").equals("")  ||  request.getParameter("productid").equals("")) {
					request.setAttribute("messageErr", "One or more fields are empty.");
					request.getRequestDispatcher("ProductDetail.jsp").forward(request, response);
					return;
				}
		        int quantity=Integer.parseInt(request.getParameter("quantity"));
		        int userid=Integer.parseInt(request.getParameter("userid"));
		        int productid=Integer.parseInt(request.getParameter("productid"));
		        Cart cart =new Cart();
		        cart.setIdUser(userid);
		        cart.setIdProduct(productid);
		        cart.setQuantity(quantity);
		        job.add(cart);
				response.sendRedirect("CartShow");  		
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

