<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Sign In</title>
</head>
<body>
	<p><a href="SignUp.jsp" >Sign up</a></p>
	<p><a href="index.jsp" >Home Page</a> </p>
	<p>Please fill this form with your login and password then submit:</p>
	<FORM METHOD="POST" action="UserSignIn">
		<P> Login: <INPUT NAME="login" TYPE="text" SIZE=" 25" MAXLENGTH=" 25">
		<P> Password: <INPUT NAME="password" TYPE="password" SIZE=" 25" MAXLENGTH=" 25">
		<P><INPUT TYPE="SUBMIT" value="Submit"> <INPUT TYPE="RESET" value="Reset">
	</FORM>
	<p>${messageErr}</p>
</body>
</html>