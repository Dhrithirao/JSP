<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SCKS</title>
</head>
<body background="images/bc1.jpg">
<br/><br/><br/><br/><br/><br/><br/><br/>
<center>
<%
HttpSession session1 = request.getSession(false);
String dname = request.getParameter("dname");
session.setAttribute("dname", dname);
%>

<pre style="font-family: Times New Roman; font-size: 35px;">
<a href="DataOwnerHome.jsp">Home</a><br/>
<a href="UploadFile.jsp">UplaodFile</a><br/>
<a href="SendKey.jsp">Send Key</a><br/>
<a href="Home.jsp">Logout</a><br/>

</pre>

</center>
</body>
</html>