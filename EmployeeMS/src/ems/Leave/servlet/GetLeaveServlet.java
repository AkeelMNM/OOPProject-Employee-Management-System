package ems.Leave.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class GetLeaveServlet
 */
@WebServlet("/GetLeaveServlet")
public class GetLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLeaveServlet() {
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
		// TODO Auto-generated method stub
		
		ArrayList<Leave> leavelist = new ArrayList<Leave>();
		
		String LeaveID =request.getParameter("LeaveID");
		
		LeaveService leaveservice = new LeaveServiceimpt();
		leavelist =leaveservice.getLeaveByID(LeaveID);

		request.setAttribute("Leave", leavelist);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Employee/Employee Update Leave.jsp");
		dispatcher.forward(request, response);
	}

}
