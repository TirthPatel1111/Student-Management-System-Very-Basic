package in.ac.adit.sms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ac.adit.sms.dao.StudentDAOImpl;
import in.ac.adit.sms.model.Student;

public class LoginController extends HttpServlet {
	RequestDispatcher rd = null;

	public void service(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Student student = new Student();
		student.setUsername(username);
		student.setPassword(password);

		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		if (studentDAOImpl.isAuthenticated(student)) {
			HttpSession session = request.getSession();
			session.setAttribute("AUTHUSER", student.getUsername());
			rd = request.getRequestDispatcher("home.jsp");
		} else {
			request.setAttribute("ERROR", "Invalid Username / Password");
			rd = request.getRequestDispatcher("login.jsp");
		}

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
