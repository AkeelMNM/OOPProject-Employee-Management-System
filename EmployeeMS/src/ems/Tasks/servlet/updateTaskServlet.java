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
 
 */
@WebServlet("/updateTaskServlet")
public class updateTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateTaskServlet() {
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

		Tasks tasks = new Tasks();
		
		String taskId = request.getParameter("TaskId");	
		
		tasks.setTaskId(taskId);
		tasks.setTask_Name(request.getParameter("TaskName"));
		tasks.setEmployee(request.getParameter("employee"));
		tasks.setDepartment(request.getParameter("department"));
		tasks.setAssignDate(request.getParameter("AssignDate"));
		
		
		taskService TaskService = new taskServiceImpt();
		TaskService.updateTasks(taskId, tasks);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Manager/Manager View Tasks Of Employees.jsp");
		dispatcher.forward(request, response);
	}

}
