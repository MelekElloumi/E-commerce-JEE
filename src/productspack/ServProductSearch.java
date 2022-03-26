package productspack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.util.Vector;
import javax.servlet.http.HttpSession;
import userspack.*;


@WebServlet(name="ProductSearch", urlPatterns= {"/ProductSearch"})
public class ServProductSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServProductSearch() {
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
			String mc=	request.getParameter("mc");
			String sortop=	request.getParameter("sortop");
            GestProducts job= new GestProducts();
            Vector<Product> products = job.search(mc,sortop);
            if (products.size()!=0) {
            	Cookie cookie=new Cookie ("cookie", "article recherche existe");
            	response.addCookie(cookie) ;
            }
    		request.setAttribute("products", products);    		
    		request.getRequestDispatcher("ShowProducts.jsp").forward(request, response);   		
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