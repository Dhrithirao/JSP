<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%
HttpSession session1=request.getSession(false);  
String dname=(String)session.getAttribute("dname"); 
System.out.println(dname+" in line 9 in uploadfile");
%>
<head>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.Random" %>

<%@ page import="javax.swing.JOptionPane" %>
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
<!-- <img src="images/tc11.png" alt="" /> --><br/><br/><br/><br/><br/><br/><br/><br/>

 <center>
		          <a href="DataOwnerHome.jsp"><span>Home</span></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        
                  <a href="UploadFiles.jsp">Upload Files</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                    
                  <a href="SendKey.jsp"> Send Key</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;           
          		  <a href="Home.jsp"><span>Logout</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          
     </center>

  <%--    <left><h3><span> Welcome <%=dname%></span></h3></left>  --%>
     <center><p> <h1><span>Upload Data Owner Files </span></h1> </p>
    <pre>
	<form action="UploadFile" method="post" enctype="multipart/form-data">
	
		<font face="TimesNewRoman" color="Red" size="4">Upload Data : </font><input type="file" multiple="true" class="text"name="upload" /><br/>
		
		<font face="TimesNewRoman" color="Red" size="4">Public Key : </font><input type="text" maxlength="5" value="10000" readonly="readonly"class="text"  /><br/>
						
		<font face="TimesNewRoman" color="Red" size="4">Secret Key : </font><input type="text" maxlength="4" id="key" name="key" value="<%=(int)(Math.random()*10000)%>" readonly="readonly"class="text"  /><br/>
						
		<font face="TimesNewRoman" color="Red" size="4">Search Key : </font><input type="text"  name="searchkey" class="text"  /><br/>
			
		<input type="submit" value="SUBMIT" />
			
		</form>    </pre>      
           </center>
      
</body>
</html>
