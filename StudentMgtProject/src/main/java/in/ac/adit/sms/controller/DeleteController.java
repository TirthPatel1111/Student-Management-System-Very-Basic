package in.ac.adit.sms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.adit.sms.dao.StudentDAOImpl;
import in.ac.adit.sms.model.Student;

public class DeleteController extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse resp) {
//		Student student = new Student();
		StudentDAOImpl studentDaoImpl = new StudentDAOImpl();
		String username=req.getParameter("username");
//		student.setUsername(username);
		studentDaoImpl.remove(username);
		RequestDispatcher rd = rd = req.getRequestDispatcher("alluser");

		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
