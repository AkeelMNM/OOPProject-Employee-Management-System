package ems.Tasks.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ems.Tasks.service.taskServiceImpt;
import ems.Tasks.service.taskService;

/**
 * 
 */
@WebServlet("/deleteTaskServlet")
public class deleteTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteTaskServlet() {
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

		String taskId = request.getParameter("TaskID");			
		
		taskService TaskService = new taskServiceImpt();
		TaskService.removeTasks(taskId);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Manager/Manager View Tasks Of Employees.jsp");
		dispatcher.forward(request, response);
	}

}
