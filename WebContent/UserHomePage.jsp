<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <%@ page import="java.sql.*" %>
<%@ page import="java.util.List" %>
 <% Class.forName("com.mysql.jdbc.Driver");%> 
<html xmlns="http://www.w3.org/1999/xhtml">

<%

HttpSession session1=request.getSession(false);  
String uname=(String)session.getAttribute("uname"); 
String key=(String)session.getAttribute("key");
%>

<head>
<title>SCKS</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- <link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" /> -->
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/droid_sans_400-droid_sans_700.font.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
</head>

<body background="images/bc1.jpg">
<!-- <img src="images/tc11.png" alt="" /> --><br/><br/><br/><br/><br/><br/>

 <center>
          <a href="DataUserLoginSuccess.jsp"><span>Home</span></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        
          <a href="UserProfile2.jsp"><span>UserProfiles</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;         
          <a href="UserSearch.jsp">Search Files</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       
          <a href="Home.jsp"><span>Logout</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          </center>
     
  <left><h1><span> Welcome <%=uname%></span></h1></left>      
 

 
    <div><p style="text-align: center;"> <img src="images/uhome1.jpg" alt="" /></p></div>
            
            

</body>
</html>
