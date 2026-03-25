package in.biduaedtech.service;

import in.biduaedtech.daofactory.StudentDaoFactory;
import in.biduaedtech.persistance.RStudentDao;

public class StudentSeriveImpl implements RStudentService {

	RStudentDao studentDao;

	@Override
	public String addStudent(String sname, Integer sage, String saddress) throws Exception {

		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.addStudent(sname, sage, saddress);
	}

	@Override
	public String searchStudent(Integer sid) throws Exception {

		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Integer sid, String name, Integer age, String address) throws Exception {

	    studentDao = StudentDaoFactory.getStudentDao();
	    return studentDao.updateStudent(sid, name, age, address);
	}

	@Override
	public String deleteStudent(Integer sid) throws Exception {

		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.deleteStudent(sid);
	}
}