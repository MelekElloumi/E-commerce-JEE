<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html SYSTEM "about:legacy-compat">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Update Products</title>
</head>
<body>
    <% String i =request.getParameter("productid"); 
    String n =request.getParameter("productname");
    String d =request.getParameter("productdescription");
    String q =request.getParameter("productquantity");
    String p =request.getParameter("productprice");    
    %>
    <p><a href="UsersShow" >Show Users</a></p>
    <p><a href="AddUsers.jsp" >Add User</a> </p>
    <p><a href="ProductsShow" >Show Products</a> </p>
    <p><a href="AddProducts.jsp" >Add Product</a> </p>
    <p><a href="AdminHome.jsp" >Admin Page</a> </p>
    <p><a href="index.jsp" >Home Page</a> </p>
    <p><a href='UserSignOut'>Sign Out</a></p>
	<p>Put the new info of <%= n %>:</p>
	<FORM METHOD="POST" action="ProductUpdate">
		<input type="hidden" name="productid" value="<%= i %>">
		<P> Name: <INPUT NAME="name" TYPE="text" SIZE=" 25" MAXLENGTH=" 25" value="<%= n %>">
		<P> Description: <textarea NAME="description" rows="4" cols="25" MAXLENGTH="250"> <%= d %></textarea>
		<P> Quantity: <INPUT NAME="quantity" TYPE="number" min="0" step="1" SIZE=" 6"  value="<%= q %>">
		<P> Price: <input TYPE="number" min="0" step="0.01"name="price" SIZE="10" value="<%= p %>"/>
		<P><INPUT TYPE="SUBMIT" value="Submit"> <INPUT TYPE="RESET" value="Reset">
	</FORM>
	<p>${messageErr}</p>
</body>
</html>