package in.jatintech.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.jatindb.util.DB_Connection;

public class StudentDaoimpl implements RStudentDao {

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		PreparedStatement ps = null;

		try {
			Connection con = DB_Connection.getConnection(); // Gets singleton connection
			String sql = "insert into student(sname,sage,saddress) values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, sname);
			ps.setInt(2, sage);
			ps.setString(3, saddress);
			int row = ps.executeUpdate();

			if (row == 1)
				return "success";
			else
				return "fail";

		} catch (Exception e) {
			e.printStackTrace();
			return "error: " + e.getMessage();
		} finally {
			try {
				if (ps != null)
					ps.close();
				// DO NOT close connection - singleton will reuse it
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String searchStudent(Integer sid) throws SQLException, ClassNotFoundException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Connection con = DB_Connection.getConnection(); // Gets singleton connection
			String sql = "select * from student where sid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, sid);
			rs = ps.executeQuery();

			if (rs.next()) {
				Integer id = rs.getInt("sid");
				String name = rs.getString("sname");
				Integer age = rs.getInt("sage");
				String address = rs.getString("saddress");
				return id + " " + name + " " + age + " " + address;
			} else {
				return "Student Not Found";
			}
		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			// DO NOT close connection
		}
	}

	@Override
	public String updateStudent(Integer sid, String name, Integer age, String address)
			throws SQLException, ClassNotFoundException {
		PreparedStatement ps = null;

		try {
			Connection con = DB_Connection.getConnection(); // Gets singleton connection
			String sql = "update student set sname=?, sage=?, saddress=? where sid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, address);
			ps.setInt(4, sid);

			int row = ps.executeUpdate();

			if (row == 1)
				return "success";
			else
				return "fail";
		} finally {
			if (ps != null)
				ps.close();
			// DO NOT close connection
		}
	}

	@Override
	public String deleteStudent(Integer sid) throws SQLException, ClassNotFoundException {
		PreparedStatement ps = null;

		try {
			Connection con = DB_Connection.getConnection(); // Gets singleton connection
			String sql = "delete from student where sid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, sid);

			int row = ps.executeUpdate();

			if (row == 1)
				return "success";
			else
				return "fail";
		} finally {
			if (ps != null)
				ps.close();
			// DO NOT close connection
		}
	}
}