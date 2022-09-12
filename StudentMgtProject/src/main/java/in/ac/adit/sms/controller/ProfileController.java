package in.ac.adit.sms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.adit.sms.dao.StudentDAOImpl;
import in.ac.adit.sms.model.Student;

public class ProfileController  extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) {
		
		String authuser = (String)request.getSession().getAttribute("AUTHUSER");
		
		StudentDAOImpl daoImpl = new StudentDAOImpl();
		Student student = daoImpl.getStudent(authuser);
		request.setAttribute("student", student);
		
		RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
