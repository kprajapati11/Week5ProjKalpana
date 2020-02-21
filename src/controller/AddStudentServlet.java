package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListStudent;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 ListStudentHelper dao =null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String college = request.getParameter("college");
		String studentName = request.getParameter("studentName");
		
		ListStudent li = new ListStudent(college, studentName);
		dao = new ListStudentHelper();
		dao.insertStudentName(li);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}
		
}
