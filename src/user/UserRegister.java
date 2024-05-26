package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.UserBean;
import Implementations.Implementation;
import Interfaces.UserInterface;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
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
		
		String skey=request.getParameter("skey");
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("dob");
		String mobile=request.getParameter("mobile");		
		String address=request.getParameter("address");
	
		
		String activate="activate";				
		UserBean bean=new UserBean();		
		bean.setSkey(skey);
		bean.setUname(uname);
		bean.setPwd(pwd);
		bean.setEmail(email);
		bean.setGender(gender);
		bean.setDob(dob);
		bean.setMobile(mobile);		
		bean.setAddress(address);
		
		UserInterface ui=new Implementation();
		int result=ui.register(bean);
		
		if(result==1)
		{
			response.sendRedirect("UserRegSuccess.jsp");
		}else
		{
			response.sendRedirect("UserRegister.jsp");
		}
		


		
	}

}
