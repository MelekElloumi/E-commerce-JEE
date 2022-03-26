<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Sign Up</title>
</head>
<body>
	<p><a href="SignIn.jsp" >Sign in</a></p>
	<p><a href="index.jsp" >Home Page</a> </p>
	<p>Please fill this form then submit:</p>
	<FORM METHOD="POST" action="UserSignUp">
		<P> Login: <INPUT NAME="login" TYPE="text" SIZE=" 25" MAXLENGTH=" 25">
		<P> Email: <INPUT NAME="email" TYPE="text" SIZE=" 25" MAXLENGTH=" 40">
		<P> Password: <INPUT NAME="password" TYPE="password" SIZE=" 25" MAXLENGTH=" 25">
		<P><INPUT TYPE="SUBMIT" value="Submit"> <INPUT TYPE="RESET" value="Reset">
	</FORM>
	<p>${messageErr}</p>
</body>
</html>