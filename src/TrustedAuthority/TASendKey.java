package TrustedAuthority;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import Bean.Filebean;
import Implementations.Implementation;
import Interfaces.UserInterface;
import dataowner.*;

/**
 * Servlet implementation class SendKey
 */
@WebServlet("/TASendKey")
public class TASendKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TASendKey() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		System.out.println("I LOVE JAVA "+uname);
		String searchkey=request.getParameter("searchkey");
		System.out.println("I LOVE JAVA "+searchkey);
		String filename=request.getParameter("filename");
		System.out.println("I LOVE JAVA "+filename);
		String key=request.getParameter("key");
		System.out.println("I LOVE JAVA "+key);
		
		Filebean fb=new Filebean();		
		fb.setUname(uname);
		fb.setSearchkey(searchkey);
		fb.setFilename(filename);
		fb.setKey(key);
	
		
		System.out.println("uname : "+uname+" searchkey :"+searchkey+ "filename :"+filename+" security key : "+key);
		UserInterface ui=new Implementation();
		int result=ui.TASendKey1(fb);
		
		if(result==1)
		{
			JFrame f;  
			 f=new JFrame();  
			    JOptionPane.showMessageDialog(f,"Semantic-based Compound Keyword Search (SCKS) Achives Keyword Based Search FileKey Sent By TA","Alert",JOptionPane.WARNING_MESSAGE);     
			
			response.sendRedirect("TAKeySendSuccess.jsp");
		}else
		{
			
		}
		
	}

}
