package in.jatintech.servicefactory;

import in.jatintech.service.RStudentService;
import in.jatintech.service.StudentSeriveImpl;

// Connection connection = DriverManager.getConnection(url,username,password) 
public class StudentServiceFactory {

	// Make Constructor private to avoid Object Creation

	private StudentServiceFactory() {
	}

	private static RStudentService studentService = null;

	public static RStudentService getStudentService() {

		// Singleton design pattern code
		if (studentService == null) {
			studentService = new StudentSeriveImpl();

		}
		return studentService;
	}

}
