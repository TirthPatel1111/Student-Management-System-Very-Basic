package in.ac.adit.sms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.adit.sms.dao.StudentDAOImpl;
import in.ac.adit.sms.model.Student;

public class StudentCreateController extends HttpServlet {
	RequestDispatcher rd;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = new Student();

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");

		student.setUsername(username);
		student.setEmail(email);
		student.setLastname(lastname);
		student.setMobile(mobile);
		student.setPassword(password);
		student.setFirstname(firstname);

		
		
		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		if (studentDAOImpl.create(student)) {
			req.setAttribute("MESSAGE", "Signup Successful....");
			rd = req.getRequestDispatcher("login.jsp");
		}
		rd.forward(req, resp);

	}
}
