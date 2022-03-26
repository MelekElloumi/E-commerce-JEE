package productspack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import userspack.*;


@WebServlet(name="AddProducts", urlPatterns= {"/AddProducts"})
public class ServProductsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServProductsAdd() {
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
		        String name=request.getParameter("name");
		        String description=request.getParameter("description");
		        if (name==null || description == null || request.getParameter("quantity") == null|| request.getParameter("price") == null  ||  name.equals("") ||description.equals("")|| request.getParameter("quantity").equals("")|| request.getParameter("price").equals("") ) {
					request.setAttribute("messageErr", "One or more fields are empty.");
					request.getRequestDispatcher("AddProducts.jsp").forward(request, response);
					return;
				}
		        int quantity=Integer.parseInt(request.getParameter("quantity"));
		        double price=Double.parseDouble(request.getParameter("price"));
		        Product product =new Product();
		        product.setName(name);
		        product.setDescription(description);
		        product.setQuantity(quantity);
		        product.setPrice(price);
		        job.add(product);
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
