<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pockit</title>
</head>
<body background="images/bc1.jpg">
<!-- <img src="images/tc11.png" alt="" /> --><br/><br/><br/><br/><br/><br/>


<br/><br/><br/><br/>
<center><h1 align="center">
<%
HttpSession session1 = request.getSession(false);
String searchkey = request.getParameter("searchkey");
session.setAttribute("searchkey", searchkey);
%>
File Stored into Cloud Server Successfully...<br/><br/><small><a href="UploadFile.jsp">Back</a></small>
</h1></center>

</body>
</html>