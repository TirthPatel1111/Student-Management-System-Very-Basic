package in.ac.adit.sms.dao;

import java.util.List;

import in.ac.adit.sms.model.Student;

public interface StudentDAO {
	public boolean create(Student student);
	public boolean remove(String username);
	public Student getStudent(String username);
	public List<Student> getAllStudent();
	public void update(Student student);	
	
	public boolean isAuthenticated(Student student);
}
