package ems.attendance.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class UpdateAttendanceServlet
 */
@WebServlet("/UpdateAttendanceServlet")
public class UpdateAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAttendanceServlet() {
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
		
		Attendance attendance = new Attendance(); 
		
		String emp;
		
		/** ---------------------------- Updating Start Time when Employee Marking Start Work   --------------------------**/
		
		if( request.getParameter("Start_Time") != null )
		{
			emp = request.getParameter("empID");
			String A_Status="Present";
			
			String attendanceID =request.getParameter("attendanceID");
			attendance.setAttendanceID(attendanceID);
			attendance.setToday_Date(request.getParameter("Today_date"));
			attendance.setStart_Time(request.getParameter("Start_Time"));
			attendance.setStatus(A_Status);
			
			AttendanceService attendanceService = new AttendanceServiceImpt();
			attendanceService.updateAttendanceStartTime(attendanceID, attendance);
			
			
			
			if(request.getParameter("Role").equals("Employee"))
			{
				request.setAttribute("employee", emp);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Employee/Employee Attendance.jsp");
				dispatcher.forward(request, response);
			}
			
			if(request.getParameter("Role").equals("HR"))
			{
				request.setAttribute("employee", emp);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HR/HR Attendance.jsp");
				dispatcher.forward(request, response);
			}
			
			if(request.getParameter("Role").equals("Manager"))
			{
				request.setAttribute("employee", emp);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Manager/Manager Attendance.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		
		/** ---------------------------- Updating End Time when Employee Marking End Work   --------------------------**/
		
		if( request.getParameter("End_Time") != null ) //  
		{
			
			emp = request.getParameter("empID");
			String attendanceID =request.getParameter("attendanceID");
			attendance.setAttendanceID(attendanceID);
			attendance.setEnd_Time(request.getParameter("End_Time"));
			
			
			AttendanceService attendanceService = new AttendanceServiceImpt();
			attendanceService.updateAttendanceEndTime(attendanceID, attendance);
			
			AttendanceStatusService attendanceStatusService = new AttendanceStatusServiceImpt();
			String AttStID =attendanceStatusService.getAttendanceStatusID(attendanceID);
			ArrayList<AttendanceStatus> attendanceStatus = attendanceStatusService.getAttendanceStatusByID(AttStID);
			attendanceStatusService.updateAttendanceStatusWorkingDays(AttStID, attendanceStatus.get(0));
			
			if(request.getParameter("Role").equals("Employee"))
			{
				request.setAttribute("employee", emp);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Employee/Employee Attendance.jsp");
				dispatcher.forward(request, response);
			}
			
			if(request.getParameter("Role").equals("HR"))
			{
				request.setAttribute("employee", emp);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HR/HR Attendance.jsp");
				dispatcher.forward(request, response);
			}
			
			if(request.getParameter("Role").equals("Manager"))
			{
				request.setAttribute("employee", emp);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Manager/Manager Attendance.jsp");
				dispatcher.forward(request, response);
			}

		}
		
		/** -------- Reset Attendance Table Start Time and End Time & Update AttendanceStatus Table No of Leaves of the Absent Employees  ---------**/
		//
		if(request.getParameter("updateTable").equals("updateTable")) 
		{
			emp = request.getParameter("empID");
			
			AttendanceStatusService attendanceStatusService = new AttendanceStatusServiceImpt();
			attendanceStatusService.updateAttendanceStatusLeaveDays(); //Update AttendanceStatus Table No of Leaves of the Absent Employees Before Resetting Attendance Table
			
			AttendanceService attendanceService = new AttendanceServiceImpt();
			attendanceService.setAttendanceStartTimeEndTimeToNull(); //Reset Attendance Table Start Time and End Time
			
			request.setAttribute("employee", emp);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HR/HR View Employees Attendance.jsp");
			dispatcher.forward(request, response);
		}
	}

}
