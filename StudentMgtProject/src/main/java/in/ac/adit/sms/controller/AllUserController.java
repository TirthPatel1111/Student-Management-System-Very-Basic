package in.ac.adit.sms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.adit.sms.dao.StudentDAOImpl;

public class AllUserController extends HttpServlet{

	public void service(HttpServletRequest request, HttpServletResponse response) {
		StudentDAOImpl daoImpl = new StudentDAOImpl();
		request.setAttribute("studentlist", daoImpl.getAllStudent());
		
		RequestDispatcher rd = request.getRequestDispatcher("alluser.jsp");
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
