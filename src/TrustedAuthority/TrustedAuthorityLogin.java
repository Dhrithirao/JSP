package TrustedAuthority;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrustedAuthorityLogin
 */
@WebServlet("/TrustedAuthorityLogin")
public class TrustedAuthorityLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrustedAuthorityLogin() {
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
		
		String taname=request.getParameter("taname");
		String tapwd=request.getParameter("tapwd");
		
		System.out.println("Trusted Authority Login...........");
	
		
		if(taname.equalsIgnoreCase("TrustedAuthority") && tapwd.equalsIgnoreCase("TrustedAuthority")){
		
				response.sendRedirect("TrustedAuthorityHome.jsp");
		}
		else
		{
			response.sendRedirect("TrustedAuthorityLogin.jsp");
		
		}
	}

}
