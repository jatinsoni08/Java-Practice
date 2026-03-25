package in.biduaedtech.daofactory;

import in.biduaedtech.persistance.RStudentDao;
import in.biduaedtech.persistance.StudentDaoimpl;

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