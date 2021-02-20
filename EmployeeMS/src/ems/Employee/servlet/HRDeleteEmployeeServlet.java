package ems.Employee.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ems.Employee.service.HREmployeeServiceImpt;
import ems.Employee.service.HREmployeeServiceInterface;

/**
 * Servlet implementation class HRDeleteEmployeeServlet
 */
/**
 * @author Zumry 
 * IT NO:IT19175126
 *
 */
@WebServlet("/HRDeleteEmployeeServlet")
public class HRDeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HRDeleteEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		String Employee_Id = request.getParameter("EmployeeID");
		
		HREmployeeServiceInterface DeleteEmployee = new HREmployeeServiceImpt();
		DeleteEmployee.removeEmployee(Employee_Id);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HR/HR View Employees.jsp");
		dispatcher.forward(request, response);
	}

}
