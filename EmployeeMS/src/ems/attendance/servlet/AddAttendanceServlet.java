package ems.attendance.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.model.Attendance;
import com.ems.model.AttendanceStatus;

import ems.attendance.service.AttendanceService;
import ems.attendance.service.AttendanceServiceImpt;
import ems.attendanceStatus.service.AttendanceStatusService;
import ems.attendanceStatus.service.AttendanceStatusServiceImpt;

/**  @author Akeel M.N.M
 	IT NO:IT19153414
**/

/**
 * Servlet implementation class AddAttendanceServlet
 */
@WebServlet("/AddAttendanceServlet")
public class AddAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAttendanceServlet() {
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

			/** ---------------------------- Creating New Attendance  --------------------------**/
			
			Attendance attendance = new Attendance();
			
			attendance.setEmployee(request.getParameter("employeeName"));
			attendance.setDepartment(request.getParameter("department"));
			attendance.setStatus("Absent");
			
			AttendanceService attendanceService = new AttendanceServiceImpt();
			attendanceService.addAttendance(attendance);
			
			/** ---------------------------- Creating New Attendance  --------------------------**/
			
			AttendanceStatus attendancestatus = new AttendanceStatus();
			String EmployeeName = request.getParameter("employeeName");
			String AttendanceID = attendanceService.getAttendanceID(EmployeeName); //Getting Newly Created Attendances Attendance ID
			int ID = 0;
			
			attendancestatus.setAttId(AttendanceID);
			attendancestatus.setEmployee(request.getParameter("employeeName"));
			attendancestatus.setDepartment(request.getParameter("department"));
			attendancestatus.setNoWorkingDays(ID);
			attendancestatus.setNoLeaveDays(ID);
			
			AttendanceStatusService attendanceStatusService = new AttendanceStatusServiceImpt();
			attendanceStatusService.addAttendanceStatus(attendancestatus);
			
			
			
			request.setAttribute("attendance", attendance);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HR/HR Add New Employee Attendance.jsp");
			dispatcher.forward(request, response);
		

	}

}
