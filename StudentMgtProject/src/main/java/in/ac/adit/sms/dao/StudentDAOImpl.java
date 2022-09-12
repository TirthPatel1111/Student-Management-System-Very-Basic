package in.ac.adit.sms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.ac.adit.sms.model.Student;

public class StudentDAOImpl implements StudentDAO {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private final String URL = "jdbc:mysql://localhost:3306/sms_db";
	private final String DBUSER = "root";
	private final String DBPASSWORD = "";

	private String sql = null;

	public StudentDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, DBUSER, DBPASSWORD);
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(Student student) {

		String sql1 = "INSERT INTO login_tbl VALUES ('" + student.getUsername() + "','" + student.getPassword() + "')";
		String sql2 = "INSERT INTO userinfo_tbl (username,firstname,lastname,email,mobile) VALUES ('"
				+ student.getUsername() + "','" + student.getFirstname() + "','" + student.getLastname() + "','"
				+ student.getEmail() + "','" + student.getMobile() + "')";

		System.out.println(sql1);
		System.out.println(sql2);
		try {
			statement.execute(sql1);
			statement.execute(sql2);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(String username) {
		String sql1 = "DELETE FROM userinfo_tbl WHERE username ='" + username + "'";
		String sql2 = "DELETE FROM login_tbl WHERE username ='" + username + "'";
		System.out.println(sql1);
		System.out.println(sql2);
		try {
			System.out.println(sql1);
			System.out.println(sql2);
			statement.execute(sql1);
			statement.execute(sql2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Student getStudent(String username) {
		sql = "SELECT * FROM userinfo_tbl WHERE username='" + username + "'";
		System.out.println(sql);
		try {
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				Student student = new Student();
				student.setUsername(username);
				student.setFirstname(resultSet.getString("firstname"));
				student.setLastname(resultSet.getString("lastname"));
				student.setEmail(resultSet.getString("email"));
				student.setMobile(resultSet.getString("mobile"));
				return student;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		sql = "SELECT * FROM userinfo_tbl";
		System.out.println(sql);
		List<Student> studentList = new ArrayList<Student>();
		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Student student = new Student();
				student.setUsername(resultSet.getString("username"));
				student.setFirstname(resultSet.getString("firstname"));
				student.setLastname(resultSet.getString("lastname"));
				student.setEmail(resultSet.getString("email"));
				student.setMobile(resultSet.getString("mobile"));
				studentList.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public void update(Student student) {
		sql="UPDATE userinfo_tbl SET firstname='"+student.getFirstname()+"', lastname='"+student.getLastname()+"', email='"+student.getEmail()+"', mobile='"+student.getMobile()+"'  WHERE username='"+student.getUsername()+"';";
		System.out.println(sql);
		try {
			int ans = statement.executeUpdate(sql);
			System.out.println(ans+" Record has been Updated...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		return student;
	}

	@Override
	public boolean isAuthenticated(Student student) {
		sql = "SELECT * FROM login_tbl where USERNAME = '" + student.getUsername() + "' and PASSWORD = '"
				+ student.getPassword() + "'";
		System.out.println(sql);
		try {
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
