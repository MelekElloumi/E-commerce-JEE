<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Admin Home</title>
</head>
<body>
	<p>Welcome ${user.login}</p>
	<p><a href="UsersShow" >Show Users</a></p>
    <p><a href="AddUsers.jsp" >Add User</a> </p>
    <p><a href="ProductsShow" >Show Products</a> </p>
    <p><a href="AddProducts.jsp" >Add Product</a> </p>
    <p><a href="index.jsp" >Home Page</a> </p>
    <p><a href='UserSignOut'>Sign Out</a></p>
    <br><p>${messageYes}</p>
</body>
</html>