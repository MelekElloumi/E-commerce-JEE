package productspack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import userspack.*;


@WebServlet(name="ProductDetail", urlPatterns= {"/ProductDetail"})
public class ServProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServProductDetail() {
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
			int productid=Integer.parseInt(request.getParameter("productid"));	
            GestProducts job= new GestProducts();
            Product product = job.detail(productid);
    		request.setAttribute("product", product);
    		request.getRequestDispatcher("ProductDetail.jsp").forward(request, response);
    		
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

