package cloudserver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CloudServerLogin
 */
@WebServlet("/CloudServerLogin")
public class CloudServerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloudServerLogin() {
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
		
		String csname=request.getParameter("csname");
		String cspwd=request.getParameter("cspwd");
		
		System.out.println("Trusted Authority Login...........");
	
		
		if(csname.equalsIgnoreCase("CloudServer") && cspwd.equalsIgnoreCase("CloudServer")){
		
				response.sendRedirect("CloudServerHome.jsp");
		}
		else
		{
			response.sendRedirect("CloudServerLogin.jsp");
		
		}
	}

}
