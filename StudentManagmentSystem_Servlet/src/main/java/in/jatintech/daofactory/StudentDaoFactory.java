package in.jatintech.daofactory;

import in.jatintech.persistence.RStudentDao;
import in.jatintech.persistence.StudentDaoimpl;

public class StudentDaoFactory {

	private StudentDaoFactory() {

	}
	private static RStudentDao studentDao = null;

	public static RStudentDao getStudentDao() {
		if (studentDao == null) {
			studentDao = new StudentDaoimpl();
		}
		return studentDao;
	}
}