package in.ac.adit.sms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.adit.sms.dao.StudentDAOImpl;
import in.ac.adit.sms.model.Student;

public class ProfileEdit extends HttpServlet{

	RequestDispatcher rd = null;
	public void service(HttpServletRequest request, HttpServletResponse response) {
		Student student = new Student();
		StudentDAOImpl studentDaoImpl = new StudentDAOImpl();
		String username = request.getParameter("username");
		student.setUsername(username);
		student = studentDaoImpl.getStudent(username);
		
		
		request.setAttribute("student", student);

		RequestDispatcher rd = request.getRequestDispatcher("profileUpdate.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		studentDaoImpl.update(student);
		
		
		
	}
}
