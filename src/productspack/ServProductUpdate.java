package productspack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import userspack.*;


@WebServlet(name="ProductUpdate", urlPatterns= {"/ProductUpdate"})
public class ServProductUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServProductUpdate() {
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
				GestProducts job= new GestProducts();
				int productid=Integer.parseInt(request.getParameter("productid"));
		        String name=request.getParameter("name");
		        String description=request.getParameter("description");

		        if (name==null || description == null || request.getParameter("productid") == null  || request.getParameter("quantity") == null|| request.getParameter("price") == null  ||  name.equals("") ||description.equals("")|| request.getParameter("quantity").equals("")|| request.getParameter("price").equals("")) {
					request.setAttribute("messageErr", "One or more fields are empty.");
					request.getRequestDispatcher("UpdateProducts.jsp").forward(request, response);
					return;
				}
		        int quantity=Integer.parseInt(request.getParameter("quantity"));
		        double price=Double.parseDouble(request.getParameter("price"));
		        job.update(productid,name,description,quantity,price);
				response.sendRedirect("ProductsShow");  		
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
