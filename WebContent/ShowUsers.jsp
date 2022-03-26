<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="java.util.Vector" %>
 <%@ page import="userspack.User" %>
    <%@ page import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <title>Show Users</title>
    </head>
    <body>
    	<p><a href="AddUsers.jsp" >Add User</a> </p>
   		<p><a href="ProductsShow" >Show Products</a> </p>
   		<p><a href="AddProducts.jsp" >Add Product</a> </p>
   		<p><a href="AdminHome.jsp" >Admin Page</a> </p>
   		<p><a href="index.jsp" >Home Page</a> </p>
        <p><a href='UserSignOut'>Sign Out</a></p>
        <table border="1" width="80%">
        <tr>
        <th>ID</th> <th>Login</th> <th>Email</th><th>Password</th> <th>Admin</th> <th> Action </th>
        </tr>
        <%
        HttpSession maSession = request.getSession(false);        
        User us= (User) maSession.getAttribute("user");
          Vector<User> u= (Vector<User>) request.getAttribute("users");
          for (User user : u) {
        %>
        <tr>
        <td><%  out.println(user.getIdUser());  %></td>
        <td><%  out.println(user.getLogin());  %></td>
		<td><%  out.println(user.getEmail());  %></td>
		<td><%  out.println(user.getPassword());  %></td>
		<td><%  if (user.getAdmin()==0) out.println("NO"); else out.println("YES"); %></td>
		<td><%  out.println(" <a href='UpdateUsers.jsp?userid="+user.getIdUser()+"&userlogin="+user.getLogin()+"&userpassword="+user.getPassword()+"&useremail="+user.getEmail()+"&useradmin="+user.getAdmin()+"'>Update</a>");if (!us.getIdUser().equals( user.getIdUser())){ out.println(" <a href='./UserDelete?userid="+user.getIdUser()+"'>Delete</a>");} %></td>
        </tr>
		<% } %>
        </table> <br>
    </body>
</html>