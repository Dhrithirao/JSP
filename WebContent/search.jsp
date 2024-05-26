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

String content=request.getParameter("content");

HttpSession session1=request.getSession(false);  
String uname=(String)session.getAttribute("uname"); 
String key=(String)session.getAttribute("key");
session.setAttribute("content",content);
%>
<title>SCKS</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/droid_sans_400-droid_sans_700.font.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
<script type="text/javascript" src="js/downloadsu.js"></script>
</head>
<body background="images/bc1.jpg">
<br/><br/><br/><br/><br/><br/>
 <center>
       
        
     <br/>  <br/></center>
     <a href="UserSearch.jsp">Back</a> 
       <left><h3><span> Welcome <%=uname%></span></h3></left>      
     
  <% //String server=(String)session2.getAttribute("server");    
 System.out.println("content......="+content);    %>
     <center>    
             <b>
            <strong>
                   
            <table style="width: 60%" border="1">
            <tr style="color: red "><td>SearchKey</td><td>File</td><td>Size</td><td> Decrypt</td></tr>
          <%
       
		int total=0;
			
				
				String[] keyword=content.split(" ");
				
				for(int i=0;i<=keyword.length-1;i++)
				{
				String q="select searchkey,filename,type,size,path,seckey,content from files where content like'"+keyword[i]+"%'";
				 System.out.println("content place 1......="+content); 
				ps=Connections.con().prepareStatement(q);
				resultSet=ps.executeQuery();
				
				while(resultSet.next())
				{
					String q1="insert into searchcontent values(?,?,?,?)";
					String filename=(String)session.getAttribute("filename");
				
					ps=Connections.con().prepareStatement(q1);
					ps.setString(1, uname);
					ps.setString(2, content);
					ps.setString(3, resultSet.getString(2));
					ps.setString(4, resultSet.getString(6));
					
					ps.executeUpdate();
					
					System.out.println("content place 3......="+content);
					System.out.println("ffffffffffffffffff"+resultSet.getString(2));
					%>
				<tr>
				<td><%=resultSet.getString(1) %></td>
				<td><a href="CloudDataBase/encrypteddata/<%=resultSet.getString(2)%>" target='_blank' title="Click here to Open Encrypted file"><%=resultSet.getString(2)%></td>
				<td><%=resultSet.getString(4) %></td>
				<td><a href="ContentDecrypt.jsp?content=<%=content%>" /><input type="submit" value="Decrypt" /></td>
				</tr>
					<%	}
				}
				
						%> 
	
           </table>
           </strong>
           </b>
           
            <br/><br/>
             
            </center>
         
</body>
</html>
