package ems.Leave.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.model.Leave;

import ems.Leave.service.LeaveService;
import ems.Leave.service.LeaveServiceimpt;



/**
 * 
 * @author Nusky
 * IT NO:IT19167442
 */




/**
 * Servlet implementation class AddLeave  
 */
@WebServlet("/AddLeaveServlet")
public class AddLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddLeaveServlet() {
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
		
		Leave leave = new Leave();
	
		leave.setEmployee(request.getParameter("employee"));
		leave.setDepartment(request.getParameter("Department"));
		
		leave.setStarting_Date(request.getParameter("Starting_Date"));
		leave.setEnd_Date(request.getParameter("End_Date"));
		leave.setL_Status(request.getParameter("L_Status"));
		leave.setDescription(request.getParameter("Description"));

		LeaveService leaveService = new LeaveServiceimpt();
		leaveService.addLeave(leave);

		request.setAttribute("leave", leave);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Employee/Employee Applyed Leave.jsp");
		dispatcher.forward(request, response);
		

		
		
		
		
		
		
		
	}

}
