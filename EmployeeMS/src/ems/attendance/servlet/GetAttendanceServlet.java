package ems.attendance.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**  @author Akeel M.N.M
	IT NO:IT19153414
**/

/**
 * Servlet implementation class GetAttendanceServlet
 */
@WebServlet("/GetAttendanceServlet")
public class GetAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAttendanceServlet() {
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
		
		String no =request.getParameter("getEmp");
		
		if(no.equals("chkEmp"))
		{
			request.setAttribute("emp", "getEmployee");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HR/HR Add New Employee Attendance.jsp");
			dispatcher.forward(request, response);
		}
	}

}
