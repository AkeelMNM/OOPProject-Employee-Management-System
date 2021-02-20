package ems.login.serviceAndservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.model.Login;

/**
   @author Akeel M.N.M
   IT NO:IT19153414
 **/


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		
		
		LoginServiceImpt loginservie = new LoginServiceImpt();
		boolean b = loginservie.checkUser(request.getParameter("username"), request.getParameter("password"));
		
		if(b == true)
		{
			ArrayList<String> arrayList = loginservie.checkLogin(request.getParameter("username"), request.getParameter("password"));
		
			String empid = arrayList.get(2);
			String role = arrayList.get(3);
		
			if(empid != null && role != null)
			{
				if(role.equals("Employee"))
				{
					request.setAttribute("employeeid", empid);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Employee/Employee Attendance.jsp");
					dispatcher.forward(request, response);
				}
				else if(role.equals("HR"))
				{
					request.setAttribute("employeeid", empid);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HR/HR Attendance.jsp");
					dispatcher.forward(request, response);
				}
				else if(role.equals("Manager"))
				{
					request.setAttribute("employeeid", empid);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Manager/Manager Attendance.jsp");
					dispatcher.forward(request, response);
				}
			}
		}
		else
		{
			request.setAttribute("result", "NoResult");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
	}

}
