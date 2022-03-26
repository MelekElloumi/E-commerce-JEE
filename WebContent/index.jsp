<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ page import="javax.servlet.http.HttpSession" %>
 <%@ page import="userspack.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>TP6</title>
</head>
<body>
<p>Welcome to our E-Shop</p>
    <%
HttpSession maSession = request.getSession(false);
if(maSession != null){ 	
	User us= (User) maSession.getAttribute("user");
	if (us !=null){
		if(us.getAdmin()==0)
	   		out.println("<p><a href='UserHome.jsp'> "+us.getLogin()+" Page</a></p>");
		if(us.getAdmin()==1)
	   		out.println("<p><a href='AdminHome.jsp'>Admin Page</a></p>");
		out.println("<p><a href='UserSignOut'>Sign Out</a></p>");
	}
	else{
		out.println("<p><a href='SignIn.jsp' >Sign in</a></p>");
		out.println("<p><a href='SignUp.jsp' >Sign up</a> </p>");
	}
}
else{
	out.println("<p><a href='SignIn.jsp' >Sign in</a></p>");
	out.println("<p><a href='SignUp.jsp' >Sign up</a> </p>");
}
%>
<p>${messageYes}</p>
</body>
</html>