package in.ac.adit.sms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.adit.sms.dao.StudentDAOImpl;
import in.ac.adit.sms.model.Student;

public class StudentUpdated extends HttpServlet{
RequestDispatcher rd;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = new Student();

		String username = req.getParameter("usernameU");
		String firstname = req.getParameter("firstnameU");
		String lastname = req.getParameter("lastnameU");
		String email = req.getParameter("emailU");
		String mobile = req.getParameter("mobileU");

		student.setUsername(username);
		student.setEmail(email);
		student.setLastname(lastname);
		student.setMobile(mobile);
		student.setFirstname(firstname);
		
		
		
		StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
		studentDAOImpl.update(student);

		req.setAttribute("student", student);

			req.setAttribute("MESSAGE", "Updated Successful....");
			rd = req.getRequestDispatcher("alluser");
		
		rd.forward(req, resp);

	}
}
