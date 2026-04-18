package in.jatintech.service;

public interface RStudentService {

	public String addStudent(String sname, Integer sage, String saddress) throws Exception;

	public String searchStudent(Integer sid) throws Exception;

	public String updateStudent(Integer sid, String name, Integer age, String address) throws Exception;

	public String deleteStudent(Integer sid) throws Exception;
}