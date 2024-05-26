<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SCKS</title>
</head>
<body background="images/bc1.jpg">
<br/><br/><br/><br/><br/><br/>
 
 <center style="font-family: Times New Roman; font-size: 20px;">
	 <a href="Home.jsp"><span>Home Page</span></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <a href="UserLogin.jsp"><span>UserLogin</span></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <a href="UserRegister.jsp"><span>UserRegister</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     
   <br/><br/><br/>
      <center><h1><span> User Login </span></h1> </center>  
     <form action="UserLogin" method="post">
  <pre style="font-family: Times New Roman; font-size: 25px; color: red;">
     
  User Name : <input type="text" name="uname" placeholder="Enter User Name"></br>
  Password    : <input type="password" name="pwd" placeholder="Enter password"> </br> 
  Key	    : <input type="text" name="skey" placeholder="Enter Key"> </br> 
 
 <input type="submit" value="Login">

</pre>
  </form>
 </center>
</body>
</html>