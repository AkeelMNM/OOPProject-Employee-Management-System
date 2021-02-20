package ems.Tasks.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.model.Tasks;

import ems.Tasks.service.taskServiceImpt;
import ems.Tasks.service.taskService;

/**
 * 
 */
@WebServlet("/addTaskServlet")
public class addTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTaskServlet() {
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

		Tasks task = new Tasks();
		
		task.setTask_Name(request.getParameter("TaskName"));
		task.setEmployee(request.getParameter("Employee"));
		task.setDepartment(request.getParameter("department"));
		task.setAssignDate(request.getParameter("AssignDate"));
		
		taskService TaskService = new taskServiceImpt();
		TaskService.addTask(task);

		request.setAttribute("task", task);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Manager/Manager View Tasks Of Employees.jsp");
		dispatcher.forward(request, response);
	}

}
