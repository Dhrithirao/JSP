<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body background="images/bc1.jpg">
<br/><br/><br/><br/><br/>
 
 <center style="font-family: Times New Roman; font-size: 20px;">
	 <a href="Home.jsp"><span>Home Page</span></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <a href="UserLogin.jsp"><span>UserLogin</span></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <a href="UserRegister.jsp"><span>UserRegister</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <br/>
   
   <center><h1><span>User Register </span></h1> </center>
     <form action="UserRegister" method="post">
  <pre style="font-family: Times New Roman; font-size: 20px; color: red;">
     
  Key    : <input type="text" name="skey" value="<%=(int)(Math.random()*100000)%>" readonly="readonly"> <br/>
  User Name : <input type="text" name="uname" placeholder="Enter User Name"><br/>
  Password    : <input type="password" name="pwd" placeholder="Enter password"> <br/>
  Email Id : <input type="email" name="email" placeholder="Enter Email Id"><br/>
  Gender    :  <input type="radio" name="gender" value="male"/>Male	<input type="radio" name="gender" value="female"/>Female<br/>
  DOB : <input type="date" name="dob" ><br/> 
  Mobile Number : <input type="number" name="mobile" placeholder="Enter Mobile Number"> <br/>
  Address : <input type="text" name="address" placeholder="Enter Address"><br/>
  
  <input type="submit" value="SUBMIT">

</pre>
  </form>
 </center>
</body>
</html>