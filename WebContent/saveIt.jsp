<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="Connections.Connections"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <script type="text/javascript" src="script/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/downloadsu.js"></script> -->

<title>SCKS</title>
</head>
<body>
<%Connection connection=Connections.con();
PreparedStatement ps=connection.prepareStatement("SELECT seckey FROM files where  filename='"+request.getParameter("county")+"' and seckey='"+request.getParameter("key")+"'");
System.out.println("SELECT file_key FROM metadata where  filename='"+request.getParameter("county")+"' and file_key='"+request.getParameter("key")+"'");
ResultSet set=ps.executeQuery();
String key="";
if(set.next()){
key=set.getString(1).trim();
System.out.println("key"+key);
}
if(key.equals(request.getParameter("key"))){
	System.out.println("IF ------------------->");
%>
<div id="msg">valid key</div>
<%
}else{ 
	System.out.println("ELSE ------------------->");
%>
<div id="msg">invalid key</div>
<%} %>
<form action="Download" method="post" id="myForm" >
<input type="text" name="fname" id="filename"/>
</form>
</body>
</html>


<%-- <%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.connection.Database"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SCKS</title>
</head>
<body>
<%Connection connection=Database.con();
PreparedStatement ps=connection.prepareStatement("SELECT file_key FROM metadata where  filename='"+request.getParameter("county")+"' and file_key='"+request.getParameter("key")+"'");
System.out.println("SELECT file_key FROM metadata where  filename='"+request.getParameter("county")+"' and file_key='"+request.getParameter("key")+"'");
ResultSet set=ps.executeQuery();
String key="";
if(set.next()){
key=set.getString(1).trim();
System.out.println("key"+key);
}
if(key.equals(request.getParameter("key"))){
	System.out.println("IF ------------------->");
%>
<div id="msg">valid key</div>
<%
}else{ 
	System.out.println("ELSE ------------------->");
%>
<div id="msg">invalid key</div>
<%} %>
<form action="Download" method="post" id="myForm" >
<input type="text" name="fname" id="filename"/>
</form>
</body>
</html> --%>