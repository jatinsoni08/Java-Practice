package in.biduaedtech.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.biduatech.util.DBConnection;

public class StudentDaoimpl implements RStudentDao {

    @Override
    public String addStudent(String sname, Integer sage, String saddress)
            throws SQLException, ClassNotFoundException {

    	Connection con = DBConnection.getConnection();

        String sql = "insert into student(sname,sage,saddress) values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, sname);
        ps.setInt(2, sage);
        ps.setString(3, saddress);

        int row = ps.executeUpdate();

        if (row == 1)
            return "success";
        else
            return "fail";
    }
    
    @Override
    public String searchStudent(Integer sid) throws SQLException, ClassNotFoundException {
    	
    	 Connection con = DBConnection.getConnection();
    	
    	String sql = "select * from student where sid=?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setInt(1, sid);

        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {

            Integer id = rs.getInt("sid");
            String name = rs.getString("sname");
            Integer age = rs.getInt("sage");
            String address = rs.getString("saddress");

            return id + " " + name + " " + age + " " + address;
        } 
        else {
            return "Student Not Found";
        }
    }

    @Override
    public String updateStudent(Integer sid, String name, Integer age, String address) throws SQLException, ClassNotFoundException {
    	
    	 Connection con = DBConnection.getConnection();
        
    	 String sql = "update student set sname=?, sage=?, saddress=? where sid=?";
    	 PreparedStatement ps = con.prepareStatement(sql);

    	 ps.setString(1, name);
    	 ps.setInt(2, age);
    	 ps.setString(3, address);
    	 ps.setInt(4, sid);
        
        int row = ps.executeUpdate();

        if (row == 1)
            return "success";
        else
            return "fail";
    }

    @Override
    public String deleteStudent(Integer sid) throws SQLException, ClassNotFoundException {

    	 Connection con = DBConnection.getConnection();

    	    String sql = "delete from student where sid=?";
    	    PreparedStatement ps = con.prepareStatement(sql);

    	    ps.setInt(1, sid);

    	    int row = ps.executeUpdate();

    	    if (row == 1)
    	        return "success";
    	    else
    	        return "fail";
    }
}