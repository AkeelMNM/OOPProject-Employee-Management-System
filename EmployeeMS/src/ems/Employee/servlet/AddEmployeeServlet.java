package ems.Employee.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.model.Employee;
import com.ems.model.Login;

import ems.Employee.service.HREmployeeServiceImpt;
import ems.Employee.service.HREmployeeServiceInterface;
/**
 * Servlet implementation class AddEmployee
 */
/**
 * @author Zumry
 * IT NO:IT19175126
 *
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
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
		
		Employee employee = new Employee();
		Login login = new Login();
		
		employee.setFullname(request.getParameter("name"));
		employee.setJobTitle(request.getParameter("JobTitle"));
		employee.setAddress(request.getParameter("Address"));
		employee.setGender(request.getParameter("gender"));
		employee.setDOB(request.getParameter("DOB"));
		employee.setMaritalStatus(request.getParameter("MaritalStatus"));
		employee.setNIC(request.getParameter("NIC"));
		employee.setPhoneNo(request.getParameter("PhoneNo"));
		employee.setJointDate(request.getParameter("Joint_date"));
		employee.setSalary(Double.parseDouble(request.getParameter("salary")));
		employee.setDepartment(request.getParameter("department"));
		
		login.setUsername(request.getParameter("username"));
		login.setPassword(request.getParameter("pwd"));
		login.setRole(request.getParameter("Role"));
		
		HREmployeeServiceInterface AddEmployee = new HREmployeeServiceImpt();
		AddEmployee.addEmployee(employee,login);
		
		request.setAttribute("employee", employee);
		request.setAttribute("Login", login);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HR/HR View Employees.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
