package ems.Department.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.RequestGroupInfo;

import com.ems.model.Department;
import com.ems.model.Manager;
import ems.Department.service.HRDepartmentAndManagerServiceImpt;

/**
 * Servlet implementation class AddDepartmentServlet
 */
/**
 * @author Zumry
 *	IT NO:IT19175126
 *
 */
@WebServlet("/AddDepartmentServlet")
public class AddDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDepartmentServlet() {
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

		response.setContentType("text/HTML");
		
		/**************************** Add Department ****************************/
		Department dep = new Department();
		
		dep.setName(request.getParameter("Dep_Name"));
		dep.setLocation(request.getParameter("Location"));
		
		//call back-end
		HRDepartmentAndManagerServiceImpt AddDepAndManager = new HRDepartmentAndManagerServiceImpt();
		AddDepAndManager.addDepartment(dep);		
		
		/*************************** Add Manager *********************************/
		Manager manager = new Manager();
		String EmpID = request.getParameter("Employee");		
		
		manager.setEmployee(request.getParameter("Employee"));
		manager.setDepartment(request.getParameter("Dep_Name"));
		manager.setStartingDate(request.getParameter("Starting_Date"));
		
		AddDepAndManager.addManager(manager, EmpID);
		
		request.setAttribute("Department", dep);
		request.setAttribute("Manager", manager);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HR/HR View Department.jsp");
		dispatcher.forward(request, response);
	}

}
