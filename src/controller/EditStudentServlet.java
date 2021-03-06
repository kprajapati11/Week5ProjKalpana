package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListStudent;



/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editStudentServlet")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditStudentServlet() {
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
		ListStudentHelper dao = new ListStudentHelper();
		String college = request.getParameter("college");
		String student = request.getParameter("studentName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListStudent studentToUpdate = dao.searchForStudentNameById(tempId);
		studentToUpdate.setCollege(college);
		studentToUpdate.setStudentName(student);
		dao.updateStudentName(studentToUpdate);
		getServletContext().getRequestDispatcher("/viewAllStudentsServlet").forward(request, response);
	}

}
