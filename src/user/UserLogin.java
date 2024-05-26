package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.UserBean;
import Implementations.Implementation;
import Interfaces.UserInterface;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		String pwd=request.getParameter("pwd");
		String skey=request.getParameter("skey");
		String activate=request.getParameter("activate");
		
				
		System.out.println("UserLogin");
		
		UserBean bean=new UserBean();
		
	
		bean.setUname(uname);
		bean.setPwd(pwd);
		bean.setSkey(skey);
		bean.setActivate(activate);
		
		System.out.println("helllll="+uname);
		
		UserInterface ui=new Implementation();
		String result=ui.login(bean);
	
		HttpSession session1=request.getSession();  
		session1.setAttribute("uname",uname);  
		
		session1.setAttribute("pwd",pwd); 
	
		
		if(result!=null)
		{
			response.sendRedirect("UserHomePage.jsp?uname="+uname+"pwd="+pwd);
		}
		else
		{
			response.sendRedirect("deactivate.jsp");
		}	
	}

}
