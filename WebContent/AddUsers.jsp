<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Add Users</title>
</head>
<body>
	<p><a href="ShowUsers" >Show Users</a></p>
    <p><a href="ProductsShow" >Show Products</a> </p>
    <p><a href="AddProducts.jsp" >Add Product</a> </p>
    <p><a href="AdminHome.jsp" >Admin Page</a> </p>
    <p><a href="index.jsp" >Home Page</a> </p>
    <p><a href='UserSignOut'>Sign Out</a></p>
	<p>Please fill this form then submit:</p>
	<FORM METHOD="POST" action="AddUsers">
		<P> Login: <INPUT NAME="login" TYPE="text" SIZE=" 25" MAXLENGTH=" 25">
		<P> Email: <INPUT NAME="email" TYPE="text" SIZE=" 25" MAXLENGTH=" 40">
		<P> Password: <INPUT NAME="password" TYPE="text" SIZE=" 25" MAXLENGTH=" 25">
		<P> Admin: <input type="radio" name="admin" value="1" /> Yes <input type="radio" name="admin" value="0" checked /> No
		<P><INPUT TYPE="SUBMIT" value="Submit"> <INPUT TYPE="RESET" value="Reset">
	</FORM>
	<p>${messageErr}</p>
</body>
</html>