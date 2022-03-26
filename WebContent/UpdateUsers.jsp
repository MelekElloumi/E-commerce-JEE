<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Update Users</title>
</head>
<body>
    <% String i =request.getParameter("userid"); 
    String l =request.getParameter("userlogin");
    String p =request.getParameter("userpassword");
    String e =request.getParameter("useremail");
    String a =request.getParameter("useradmin");    
    %>
    <p><a href="UsersShow" >Show Users</a></p>
    <p><a href="AddUsers.jsp" >Add User</a> </p>
    <p><a href="ProductsShow" >Show Products</a> </p>
    <p><a href="AddProducts.jsp" >Add Product</a> </p>
    <p><a href="AdminHome.jsp" >Admin Page</a> </p>
    <p><a href="index.jsp" >Home Page</a> </p>
    <p><a href='UserSignOut'>Sign Out</a></p>
	<p>Put the new info of <%= l %>:</p>
	<FORM METHOD="POST" action="UserUpdate">
		<input type="hidden" name="userid" value="<%= i %>">
		<P> Login: <INPUT NAME="login" TYPE="text" SIZE=" 25" MAXLENGTH=" 25" value="<%= l %>">
		<P> Email: <INPUT NAME="email" TYPE="text" SIZE=" 25" MAXLENGTH=" 40" value="<%= e %>">
		<P> Password: <INPUT NAME="password" TYPE="text" SIZE=" 25" MAXLENGTH=" 25" value="<%= p %>">
		<P> Admin: <input type="radio" name="admin" value="1" <% if(Integer.parseInt(a)==1) out.println("checked"); %>/> Yes <input type="radio" name="admin" value="0" checked <% if(Integer.parseInt(a)==0) out.println("checked"); %>/> No
		<P><INPUT TYPE="SUBMIT" value="Submit"> <INPUT TYPE="RESET" value="Reset">
	</FORM>
	<p>${messageErr}</p>
</body>
</html>