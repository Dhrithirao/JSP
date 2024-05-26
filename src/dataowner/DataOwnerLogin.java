package dataowner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataOwnerLogin
 */
@WebServlet("/DataOwnerLogin")
public class DataOwnerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataOwnerLogin() {
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
		HttpSession ses = request.getSession();
		String dname= null;
		dname=request.getParameter("dname");
		System.out.println(dname);
		String dpwd=request.getParameter("dpwd");
		ses.setAttribute("dname", dname);
		System.out.println("Data Owner.jsp Login..........."+dname);
	
		
		if(dname.equalsIgnoreCase("DataOwner") && dpwd.equalsIgnoreCase("DataOwner")){
		
			response.sendRedirect("DataOwnerHome.jsp?dname=" + dname);		}
		else
		{
			response.sendRedirect("DataOwnerLogin.jsp");
		
		}

	}

}
