<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <%@ page import="productspack.Product" %>
 <%@ page import="userspack.User" %>
    <%@ page import="java.util.*" %> 
<!DOCTYPE html SYSTEM "about:legacy-compat">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Product Detail</title>
</head>
<body>
 	<%
        HttpSession maSession = request.getSession(false);        
        User us= (User) maSession.getAttribute("user");
        int i=us.getIdUser();
        if (us.getAdmin()==1){
        	out.println("<p><a href='UsersShow' >Show Users</a></p>");
        	out.println("<p><a href='AddUsers.jsp' >Add User</a> </p>");
        	out.println("<p><a href='ProductsShow' >Show Products</a> </p>");
        	out.println("<p><a href='AddProducts.jsp' >Add Product</a> </p>");
        	out.println("<p><a href='AdminHome.jsp' >Admin Page</a> </p>");
        } 
        if (us.getAdmin()==0){
        	out.println("<p><a href='ProductsShow' >Show Product</a> </p>");
        	out.println("<p><a href='CartShow' >Show Shopping Cart</a> </p>");
        	out.println("<p><a href='UserHome.jsp'> "+us.getLogin()+" Page</a> </p>");
        }
        %>
    <p><a href="index.jsp" >Home Page</a> </p>
    <p><a href='UserSignOut'>Sign Out</a></p>
	<p>Product Infos:</p>
	<% Product product= (Product) request.getAttribute("product");
	int pi=product.getIdProduct();	
	%>
		<P> Name: <% out.println(product.getName()); %>
		<P> Description: <%  out.println(product.getDescription());  %>
		<P> Quantity: <%  out.println(product.getQuantity());  %>
		<P> Price: <%  out.println(product.getPrice()); %>
		<P> <FORM METHOD="POST" action="AddCart">
		<input type="hidden" name="productid" value="<%= pi %>">
		<input type="hidden" name="userid" value="<%= i %>"> 
		<INPUT NAME="quantity" TYPE="number" min="1" step="1" SIZE="6" value="1" >
		<INPUT TYPE="SUBMIT" value="Add to Cart">
		</FORM>
	<p>${messageErr}</p>
</body>
</html>