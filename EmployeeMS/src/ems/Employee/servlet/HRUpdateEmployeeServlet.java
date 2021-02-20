package ems.Employee.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.model.Employee;

import ems.Employee.service.HREmployeeServiceImpt;
import ems.Employee.service.HREmployeeServiceInterface;
/**
 * @author Zumry 
 *
 */
/**
 * Servlet implementation class HRUpdateEmployeeServlet
 */

/**
 * @author Zumry 
 * IT NO:IT19175126
 *
 */
@WebServlet("/HRUpdateEmployeeServlet")
public class HRUpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HRUpdateEmployeeServlet() {
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

		
		
		Employee emp = new Employee();
		
		String EmployeeID = request.getParameter("EmployeeID");
		
		emp.setEmpID(request.getParameter("EmployeeID"));
		emp.setFullname(request.getParameter("name"));
		emp.setJobTitle(request.getParameter("JobTitle"));
		emp.setAddress(request.getParameter("Address"));
		emp.setGender(request.getParameter("gender"));
		emp.setDOB(request.getParameter("DOB"));
		emp.setMaritalStatus(request.getParameter("MaritalStatus"));
		emp.setNIC(request.getParameter("NIC"));
		emp.setPhoneNo(request.getParameter("PhoneNo"));
		emp.setJointDate(request.getParameter("Joint_date"));
		emp.setSalary(Double.parseDouble(request.getParameter("salary")));
		emp.setDepartment(request.getParameter("department"));
		
		HREmployeeServiceInterface UpdateDetails = new HREmployeeServiceImpt();
		UpdateDetails.updateEmployee(EmployeeID, emp);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HR/HR View Employees.jsp");
		dispatcher.forward(request, response);
		
	}

}
