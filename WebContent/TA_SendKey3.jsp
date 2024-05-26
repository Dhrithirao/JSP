<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page import="java.util.List" %>
 <%@ page import="java.sql.*" %>
  <%@ page import="Connections.*" %>
    <%@ page import="dataowner.*" %>
    <%@ page import="TrustedAuthority.*" %>
    
 <%  PreparedStatement ps = null;
 	ResultSet resultSet= null;
Statement st=null;
PreparedStatement ps1 = null;
	ResultSet resultSet1= null;
Statement st1=null;
String query=null;

HttpSession session1=request.getSession(false);  
String uname=(String)session.getAttribute("uname"); 

%>
<title>SCKS</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/droid_sans_400-droid_sans_700.font.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/downloadsu.js"></script>
</head>
<body background="images/bc1.jpg">
<br/><br/><br/><br/><br/><br/><br/>

 <h4>  <a href="CloudServerHome.jsp"><span>Back</span></a>&nbsp;&nbsp;&nbsp;&nbsp; <a href="Home.jsp"><span>Logout</span></a><br/>  </h4>

    <center><p> <h1><span style="font-family: Times New Roman; ">TA Content Based Send Key Info </span></h1> </p></center>

            <table style="width: 50%" border="2" align="center" bgcolor="aqua" >
            <tr style="color: red "><td>User Name</td><td>Content</td><td>File Name</td><td>Security Key</td></tr>
            				
            				<%	int total=0;            			
				
				String q="select * from tasendkeycontent";
			 
				ps=Connections.con().prepareStatement(q);
				resultSet=ps.executeQuery();
				while(resultSet.next())
				{					
					%>
				<tr>
				<td><%=resultSet.getString(1) %></td>
				<td><%=resultSet.getString(2) %></td>
				<td><%=resultSet.getString(3) %></td>
				<td><%=resultSet.getString(4) %></td>
 					 
					 	
				</tr>
					<% } %>
           </table>
                <br/>  <br/> <br/>  <br/> 
 
           
</body>
</html>
