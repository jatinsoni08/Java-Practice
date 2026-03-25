package in.biduaedtech.servicefactory;

import in.biduaedtech.service.RStudentService;
import in.biduaedtech.service.StudentSeriveImpl;

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
