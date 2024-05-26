package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Connections {
	PreparedStatement ps=null;
	PreparedStatement ps1=null;
	ResultSet rs=null;
	Connection con=null;


	public static Connection con() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/vtjcc22_2021","root","pinky173");
		return connection;
	}
	
	


}
