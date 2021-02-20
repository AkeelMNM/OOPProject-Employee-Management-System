package ems.attendance.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ems.attendance.service.AttendanceService;
import ems.attendance.service.AttendanceServiceImpt;

/**  @author Akeel M.N.M
	IT NO:IT19153414
**/

/**
 * Servlet implementation class DeleteAttendanceServlet
 */
@WebServlet("/DeleteAttendanceServlet")
public class DeleteAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAttendanceServlet() {
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
	
		/** ---------------------------- Removing Attendance  --------------------------**/
		
		String AttID = request.getParameter("AttID");
		String emp = request.getParameter("EID");
		
		AttendanceService attendanceService = new AttendanceServiceImpt();
		attendanceService.removeAttendance(AttID);
		
		request.setAttribute("employee", emp);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HR/HR View Employees Attendance.jsp");
		dispatcher.forward(request, response);
	}

}
