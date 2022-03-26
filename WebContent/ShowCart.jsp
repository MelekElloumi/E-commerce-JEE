<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.util.Vector" %>
 <%@ page import="productspack.Product" %>
 <%@ page import="userspack.User" %>
 <%@ page import="cartspack.Cart" %>
    <%@ page import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <title>Show Shopping Cart</title>
    </head>
    <body>
      <%
        HttpSession maSession = request.getSession(false);        
        User us= (User) maSession.getAttribute("user");
        %> 
        <p><a href="ProductsShow" >Show Products</a></p>
        <p><a href='UserHome.jsp'> <%= us.getLogin()%> Page</a> </p>
   		<p><a href="index.jsp" >Home Page</a> </p>
        <p><a href='UserSignOut'>Sign Out</a></p>
        <p> These are the products in your shopping cart </p>
        <table border="1" width="80%">
        <tr>
        <th>Product Name</th> <th>Quantity</th> <th> Action </th>
        </tr>

        <%
          Vector<Cart> c= (Vector<Cart>) request.getAttribute("carts");
          for (Cart cart : c) {
        %>
        <tr>
        <td><%  out.println(cart.getNameProduct());  %></td>
		<td><%  out.println(cart.getQuantity());  %></td>
		<td><%  out.println(" <a href='./ProductDetail?productid="+cart.getIdProduct()+"'>Show</a>"); out.println(" <a href='./CartDelete?cartid="+cart.getIdCart()+"'>Delete</a>");} %></td>
        </tr>
        </table> <br>
    </body>
</html>