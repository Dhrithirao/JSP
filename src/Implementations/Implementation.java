package Implementations;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.*;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;
//import Bean.DeleteBean;
//import Filebean;
import Bean.UserBean;
import Bean.Filebean;
//import Bean.DataOwnerBean;
//import Connections.Connections;
import Interfaces.UserInterface;
//import Keyverficationbean;

public class Implementation implements UserInterface {
	PreparedStatement ps=null;
	PreparedStatement ps1=null;
	ResultSet rs=null;
	//Connection con=null;

	@Override
	public int register(UserBean bean) {
		int status=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/vtjcc22_2021","root","pinky173");
			
			String query="insert into userregister values(?,?,?,?,?,?,?,?,?)";
			
			ps=con.prepareStatement(query);			
			
			ps.setString(1, bean.getSkey());
			ps.setString(2, bean.getUname());
			ps.setString(3, bean.getPwd());
			ps.setString(4, bean.getEmail());
			ps.setString(5, bean.getGender());
			ps.setString(6, bean.getDob());
			ps.setString(7, bean.getMobile());			
			ps.setString(8, bean.getAddress());		
			ps.setString(9, "activate");
		
			status=ps.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return status;
	
	}

	@Override
	public String login(UserBean bean) {
		String result=null;
		try {
			System.out.println("Impl");
			
				Class.forName("com.mysql.jdbc.Driver");

				Connection con =
				DriverManager.getConnection("jdbc:mysql://localhost:3306/vtjcc22_2021","root","pinky173");
			
		if(con==null) {
			System.out.println("connected");
			
		}
			String query1="select uname from userregister where uname='"+bean.getUname()+"'and pwd='"+bean.getPwd()+"'and skey='"+bean.getSkey()+"'and activate='yes'";
		
			System.out.println(query1);
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(query1);
	      
			if(rs1.next())
			{
				result=rs1.getString(1);
				System.out.println("heeeeeeeeeeeeee"+result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ArrayList upload(Filebean bean) {
		// TODO Auto-generated method stub
		ArrayList al=new ArrayList();
		return al;
	}

	@Override
	public int fileupload(Filebean upload) {
		int status=0;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtjcc22_2021","root","pinky173");

			
			
			System.out.println("database"+upload.getUsername());
			System.out.println("database"+upload.getFilename());
			System.out.println("database"+upload.getType());
			System.out.println("database"+upload.getSize());
			System.out.println("database"+upload.getPath());
			System.out.println("database"+upload.getKey());

			
			//String	query="insert into metadata values(?,?,?,?,?,?,?)";
			String	query="insert into files values('"+upload.getUsername()+"','"+upload.getFilename()+"','"+upload.getType()+"','"+upload.getSize()+"','"+upload.getPath()+"','"+upload.getKey()+"','"+upload.getJ()+"')";
			ps=con.prepareStatement(query);	
			System.out.println(query+" in implementations line 129");
			//System.out.println(upload.getUploadcontent()+"fileeeeee");
		/*statement.setString(1, upload.getUsername());
		statement.setString(2, upload.getFilename());
		statement.setString(3, upload.getType());
		statement.setString(4, upload.getSize());
		statement.setString(5, upload.getPath());
		statement.setString(6, upload.getKey());
		//statement.setBinaryStream(7, upload.getUploadcontent());
		
	InputStream i=upload.getUploadcontent();
		//InputStream i=new FileInputStream(new File(upload.getUploadcontent()));
	statement.setBinaryStream(7, i,i.available());*/
		status=ps.executeUpdate();
		
		
		System.out.println(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status=0;
		}
		
		return status;
	}
	
	/*@Override
	public int sendKey1(Filebean fb) {
		int status=0;
		try {
			con=Connections.con();
			String query="insert into SendKeyDetails values(?,?,?,?,?)";
			
			ps=con.prepareStatement(query);			
			
			ps.setString(1, fb.getFilename());
			ps.setString(2, fb.getSize());
			ps.setString(3, fb.getKey());
			ps.setString(4, fb.getSearchkey());			
			//ps.setString(5, "accept");
		
			status=ps.executeUpdate();
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return status;
	
	}*/
	
@Override
	public int sendKey1(Filebean fb) {
		int status=0;
		String key=null,searchkey=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/vtjcc22_2021","root","pinky173");
//			HttpSession session1 = request.getSession();
//			String dusername=(String)session1.getAttribute("dname");
			String query1="select seckey,searchkey from files where filename='"+fb.getFilename()+"'";

			
			System.out.println(query1);
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery(query1);

			if (rs1.next()) {
			     key = rs1.getString(1);
			     searchkey = rs1.getString(2);
			    System.out.println("Key: " + key);
			    System.out.println("Search key: " + searchkey);
			} else {
			    System.out.println("No rows found in the ResultSet.");
			}

			
			
	/*		PreparedStatement ps1=con.prepareStatement("select name from USER where name='"+fb.getUsername()+"'");
			ResultSet rs2=ps1.executeQuery();
			while(rs2.next()){
				servername=rs2.getString(1);
				System.out.println("servername:"+servername);
				
			}*/
			
			
			String query="insert into SendKeyDetails values(?,?,?,?)";
			
			ps=con.prepareStatement(query);
			
			ps.setString(1, fb.getFilename());
			
			ps.setString(2, fb.getFilename());
			
			ps.setString(3, key);
			
			ps.setString(4, searchkey);
			
			
		
			System.out.println(fb.getFilename());
			System.out.println(key);
			System.out.println(fb.getUsername());
			//System.out.println("Dataowners servername:"+servername);
			System.out.println("Dataowners Searchkey:"+searchkey);
			status=ps.executeUpdate();
			System.out.println(status);
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return status;
	
	}
@Override
public int TASendKey1(Filebean fb) {
	int status=0;
	try {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con =
		DriverManager.getConnection("jdbc:mysql://localhost:3306/vtjcc22_2021","root","pinky173");
		
		String query1="select uname,searchkey,filename,seckey from searchkeywords where searchkey='"+fb.getSearchkey()+"'";

		System.out.println(query1);
				
		String query="insert into tasendKeydetails values(?,?,?,?)";
		
		ps=con.prepareStatement(query);
		
		ps.setString(1, fb.getUname());
		ps.setString(2, fb.getSearchkey());				
		ps.setString(3, fb.getFilename());
		ps.setString(4, fb.getKey());
		
		status=ps.executeUpdate();
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	return status;

}
@Override
public int TASendKey2(Filebean fb) {
	int status=0;
	try {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con =
		DriverManager.getConnection("jdbc:mysql://localhost:3306/vtjcc22_2021","root","pinky173");
		
		String query1="select uname,searchkey,filename,seckey from searchfilename where filename='"+fb.getFilename()+"'";

		System.out.println(query1);
				
		String query="insert into tasendkeyfilename values(?,?,?,?)";
		
		ps=con.prepareStatement(query);
		
		ps.setString(1, fb.getUname());
		ps.setString(2, fb.getSearchkey());				
		ps.setString(3, fb.getFilename());
		ps.setString(4, fb.getKey());
		
		status=ps.executeUpdate();
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	return status;

}
@Override
public int TASendKey3(Filebean fb) {
	int status=0;
	try {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con =
		DriverManager.getConnection("jdbc:mysql://localhost:3306/vtjcc22_2021","root","pinky173");
		
		String query1="select uname,content,filename,seckey from searchcontent where content='"+fb.getContent()+"'";

		System.out.println(query1);
				
		String query="insert into tasendkeycontent values(?,?,?,?)";
		
		ps=con.prepareStatement(query);
		
		ps.setString(1, fb.getUname());
		ps.setString(2, fb.getContent());				
		ps.setString(3, fb.getFilename());
		ps.setString(4, fb.getKey());
		
		status=ps.executeUpdate();
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	return status;

}


/*	@Override
	public int sendkey(Filebean fb) {
		int status=0;
		try {
			con=Connections.con();
			String servername=null;
			String query1="select seckey,searchkey from files where filename='"+fb.getFilename()+"'";

			
			System.out.println(query1);
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(query1);
			rs1.absolute(1);
			String key=rs1.getString(1);
			
			String searchkey=rs1.getString(2);
			
			
			PreparedStatement ps1=con.prepareStatement("select name from USER where name='"+fb.getUsername()+"'");
			ResultSet rs2=ps1.executeQuery();
			while(rs2.next()){
				servername=rs2.getString(1);
				System.out.println("servername:"+servername);
				
			}
			
			
			String query="insert into inbox values(?,?,?,?,?)";
			
			ps=con.prepareStatement(query);
			
			ps.setString(1, fb.getFilename());
			
			ps.setString(2, key);
			
			ps.setString(3, fb.getUsername());
			
			ps.setString(4, searchkey);
			
			ps.setString(5, "accept");
		
			System.out.println(fb.getFilename());
			System.out.println(key);
			System.out.println(fb.getUsername());
			System.out.println("Dataowners servername:"+servername);
			System.out.println("Dataowners Searchkey:"+searchkey);
			status=ps.executeUpdate();
			System.out.println(status);
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return status;
	
	}*/

/*	@Override
	public int logout(UserBean bean) {
		int status=0;
		try {
			con=Connections.con();
			String query="delete from inbox where uid=?";
			
			ps=con.prepareStatement(query);
			
			
			ps.setString(1, bean.getId());
		

			status=ps.executeUpdate();
			
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return status;
	}*/

	/*@Override
	public int update(DeleteBean db) {
		int status=0;
		try {
			con=Connections.con();
		
	
			//String query="update files SET content='"+db.getContent()+"' where filename='"+db.getFilename()+"'";
			String query="update files SET content='"+db.getContent()+"' where filename='"+db.getFilename()+"'";
			//UPDATE files SET content='HI THIS IS JAVA FILE' WHERE filename='java.txt'
		
			ps=con.prepareStatement(query);
			
		
		//	ps.setString(1, db.getSearchkey());
		//	ps.setString(2, db.getFilename());
		//	ps.setString(3, db.getSize());
			//ps.setString(1, db.getFilename());
			//ps.setString(2, db.getContent());
		

			status=ps.executeUpdate();
			
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return status;
	}
	
	@Override
	public int delete(DeleteBean db) {
		int status=0;
		try {
			con=Connections.con();
			String query="delete from files where searchkey=? and filename=? and size=?";
			
			ps=con.prepareStatement(query);
			
			
			ps.setString(1, db.getSearchkey());
			ps.setString(2, db.getFilename());
			ps.setString(3, db.getSize());

			status=ps.executeUpdate();
			
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return status;
	}
	*/
	/*@Override
	public int dataownerregister1(DataOwnerBean bean1) {
		int status=0;
		try {
			con=Connections.con();
			String query="insert into dataowner values(?,?,?,?,?,?,?,?,?)";
			
			ps=con.prepareStatement(query);
			
			
			ps.setString(1, bean1.getId());
			ps.setString(2, bean1.getName());
			ps.setString(3, bean1.getPassword());
			ps.setString(4, bean1.getDob());
			ps.setString(5, bean1.getMobile());
			ps.setString(6, bean1.getGender());
			ps.setString(7, bean1.getMail());
			ps.setString(8, bean1.getAddress());
			ps.setString(9, bean1.getInpassword());

			status=ps.executeUpdate();
			
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return status;
	
	}

	@Override
	public String dataownerlogin1(DataOwnerBean bean1) {
		String result=null;
		try {
			System.out.println("Impl");
			
				con=Connections.con();
			
			String query1="select name from dataowner where id='"+bean1.getId()+"' and password='"+bean1.getPassword()+"' and server='"+bean1.getServer()+"'";
			System.out.println(query1);
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(query1);
	      
			if(rs1.next())
			{
				result=rs1.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}*/

}
