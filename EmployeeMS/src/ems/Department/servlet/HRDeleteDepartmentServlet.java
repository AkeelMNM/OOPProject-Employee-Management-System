package ems.Department.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ems.Department.service.HRDepartmentAndManagerServiceImpt;
import ems.Department.service.HRDepartmentAndManagerServiceInterface;

/**
 * Servlet implementation class HRDeleteDepartmentServlet
 */
/**
 * @author Zumry
 * IT NO:IT19175126 
 *
 */
@WebServlet("/HRDeleteDepartmentServlet")
public class HRDeleteDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HRDeleteDepartmentServlet() {
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
		
		String DepID = request.getParameter("DepartmentID");

		HRDepartmentAndManagerServiceInterface DeleteDepartment = new HRDepartmentAndManagerServiceImpt();
		DeleteDepartment.removeDepartment(DepID);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HR/HR Employee Recruitment.jsp");
		dispatcher.forward(request, response);
		
	}

}
