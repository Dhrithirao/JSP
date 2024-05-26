<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page import="java.util.List" %>
 <%@ page import="java.sql.*" %>
  <%@ page import="Connections.*" %>
 <%  PreparedStatement ps = null;
 	ResultSet resultSet= null;
Statement st=null;
PreparedStatement ps1 = null;
ResultSet resultSet1= null;
Statement st1=null;
String query=null;

HttpSession session1=request.getSession(false);  
String name=(String)session.getAttribute("uname"); 
String uid=(String)session.getAttribute("uid");

HttpSession session2=request.getSession();  
session.setAttribute("uid",uid);  
session.setAttribute("uname",name);

%>
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
          <a href="adminhome.jsp"><span>Home</span></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="file.jsp"><span>DataOwner Files</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="UserProfile3.jsp"><span>UserProfiles</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="index.html"><span>Logout</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;              
     </center>
     <br/>  <br/>
 
    <center><p> <h1><span> Upload Files Details</span></h1> </p></center>

            <table style="width: 40%" border="1" align="center">
            <tr style="color: red "><td>SearchKey</td><td>File</td><td>Size</td><!-- <td>Delete</td> --></tr>
            				<%
            				
		int total=0;
				String q="select searchkey,filename,type,size,path from files where searchkey='"+name+"'";
				ps=Connections.con().prepareStatement(q);
				resultSet=ps.executeQuery();
				while(resultSet.next())
				{					
					%>
				<tr>
				<td><%=resultSet.getString(1) %></td>
					<td><%=resultSet.getString(2) %></td>
						<td><%=resultSet.getString(4) %></td>							
				</tr>
					<%		}							
				%>
           </table>
</body>
</html>
