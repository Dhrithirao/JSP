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
String uname=(String)session.getAttribute("uname"); 



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
            <a href="UserHomePage.jsp"><span>Home</span></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        
          <a href="UserProfile2.jsp"><span>UserProfiles</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                         
       
          <a href="index.jsp"><span>Logout</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          
     
     </center>
     <br/>  <br/>
     
     	
    <center><p> <h1><span> User Profile</span></h1> </p></center>

            <table style="width: 80%" border="1" align="center">
            <tr style="color: red", align="center"><td>UserId</td><td>UserName</td><td>Password</td><td>Email Id</td><td>Gender</td><td>DOB</td><td>Mobile</td><td>Address</td><td>Activate</td></tr>
            				<%
		int total=0;
			
				
			
				//String q="select searchkey,filename,type,size,path from files";
				String q="select * from userregister where uname='"+uname+"'";
				//String q="select * from user";
				ps=Connections.con().prepareStatement(q);
				resultSet=ps.executeQuery();
				while(resultSet.next())
				{
					
					%>
				<tr>
				<td><%=resultSet.getString(1) %></td>
					<td><%=resultSet.getString(2) %></td>
						<td>*******</td>
						<td><%=resultSet.getString(4) %></td>
						<td><%=resultSet.getString(5) %></td>
						<td><%=resultSet.getString(6) %></td>
						<td><%=resultSet.getString(7) %></td>
						<td><%=resultSet.getString(8) %></td>
						<td><%=resultSet.getString(9) %></td>
							<%-- <td>
							<form action="Delete?searchkey=<%=resultSet.getString(1) %>&filename=<%=resultSet.getString(2) %>&size=<%=resultSet.getString(4) %>" method="post">
							<input type="submit" value="DELETE"></input>
							</form>
							
							</td> --%>
				</tr>
					<%
			
				}
				
				
				%>
           </table>
               
</body>
</html>
