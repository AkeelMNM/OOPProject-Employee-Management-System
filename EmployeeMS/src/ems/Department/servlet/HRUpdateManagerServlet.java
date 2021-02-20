package ems.Department.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.model.Manager;

import ems.Department.service.HRDepartmentAndManagerServiceImpt;
import ems.Department.service.HRDepartmentAndManagerServiceInterface;

/**
 * Servlet implementation class HRUpdateManagerServlet
 */
/**
 * @author Zumry
 * IT NO:IT19175126
 *
 */
@WebServlet("/HRUpdateManagerServlet")
public class HRUpdateManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HRUpdateManagerServlet() {
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
		
		Manager manager = new Manager();
		
		String ManagerId = request.getParameter("ManagerID");
		
		manager.setManagerId(request.getParameter("ManagerID"));
		manager.setDepartment(request.getParameter("Department"));
		manager.setEmployee(request.getParameter("Employee"));
		manager.setStartingDate(request.getParameter("Starting_Date"));
		
		HRDepartmentAndManagerServiceInterface updateManager = new HRDepartmentAndManagerServiceImpt();
		updateManager.updateManager(ManagerId,manager);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HR/HR Employee Recruitment.jsp");
		dispatcher.forward(request, response);
		
	}

}
