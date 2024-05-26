package dataowner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Filebean;
import Implementations.Implementation;
import Interfaces.UserInterface;
import dataowner.*;

/**
 * Servlet implementation class SendKey
 */
@WebServlet("/SendKey")
public class SendKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendKey() {
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
		String filename=request.getParameter("fname");
		System.out.println("I LOVE JAVA "+filename);
		String size=request.getParameter("fsize");
		System.out.println("I LOVE JAVA "+size);
		String key=request.getParameter("key");
		String searchkey=request.getParameter("searchkey");
				
		Filebean fb=new Filebean();		
		fb.setFilename(filename);
		fb.setSize(size);
		fb.setKey(key);
		fb.setSearchkey(searchkey);
		
		System.out.println("filename : "+filename+ " Size : "+size +" security key : "+key +" searchkey :"+searchkey);
		UserInterface ui=new Implementation();
		int result=ui.sendKey1(fb);
		
		if(result==1)
		{
			response.sendRedirect("KeySendSuccess.jsp");
		}else
		{
			
		}
		
	}

}
