<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.util.Vector" %>
 <%@ page import="productspack.Product" %>
 <%@ page import="userspack.User" %>
    <%@ page import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <title>Show Products</title>
    </head>
    <body>
      <%
        HttpSession maSession = request.getSession(false);        
        User us= (User) maSession.getAttribute("user");
        if (us.getAdmin()==1){
        	out.println("<p><a href='UsersShow' >Show Users</a></p>");
        	out.println("<p><a href='AddUsers.jsp' >Add User</a> </p>");
        	out.println("<p><a href='AddProducts.jsp' >Add Product</a> </p>");
        	out.println("<p><a href='AdminHome.jsp' >Admin Page</a> </p>");
        } 
        if (us.getAdmin()==0){
        	out.println("<p><a href='CartShow' >Show Shopping Cart</a> </p>");
        	out.println("<p><a href='UserHome.jsp'> "+us.getLogin()+" Page</a> </p>");
        }
        %> 
   		<p><a href="index.jsp" >Home Page</a> </p>
        <p><a href='UserSignOut'>Sign Out</a></p>
        <p><FORM METHOD="POST" action="ProductSearch">
        <INPUT NAME="mc" TYPE="text" SIZE=" 25" MAXLENGTH=" 25">	                
        <INPUT TYPE="SUBMIT" value="Search">
 		<input type="radio" name="sortop" value="NAME" checked> Sort by name
 		<input type="radio" name="sortop" value="PRICE"> Sort by price
        </FORM>
        </p>
        <table border="1" width="80%">
        <tr>
        <th>ID</th> <th>Name</th> <th>Quantity</th> <th>Price</th> <th> Action </th>
        </tr>

        <%
          Vector<Product> p= (Vector<Product>) request.getAttribute("products");
          for (Product product : p) {
        %>
        <tr>
        <td><%  out.println(product.getIdProduct());  %></td>
        <td><%  out.println(product.getName());  %></td>
		<td><%  out.println(product.getQuantity());  %></td>
		<td><%  out.println(product.getPrice()); %></td>
		<td><%  out.println(" <a href='./ProductDetail?productid="+product.getIdProduct()+"'>Show</a>"); if(us.getAdmin()==1){out.println(" <a href='UpdateProducts.jsp?productid="+product.getIdProduct()+"&productname="+product.getName()+"&productdescription="+product.getDescription()+"&productquantity="+product.getQuantity()+"&productprice="+product.getPrice()+"'>Update</a>"); out.println(" <a href='./ProductDelete?productid="+product.getIdProduct()+"'>Delete</a>");}} %></td>
        </tr>
        </table> <br>
    </body>
</html>