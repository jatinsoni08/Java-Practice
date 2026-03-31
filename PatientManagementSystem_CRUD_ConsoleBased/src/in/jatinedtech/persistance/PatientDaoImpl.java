package in.jatinedtech.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.jatinedtech.dto.Patient;
import in.jatinedtech.util.DBConnection;

public class PatientDaoImpl implements RPatientDao {

    @Override
    public String addPatient(String name, Integer age, String disease, String address)
            throws SQLException, ClassNotFoundException {

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO patient(name, age, disease, address) VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, disease);
        ps.setString(4, address);

        int row = ps.executeUpdate();

        return (row == 1) ? "success" : "fail";
    }

    @Override
    public Patient searchPatient(Integer pid) throws SQLException, ClassNotFoundException {

        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM patient WHERE pid=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, pid);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Patient patient = new Patient();

            patient.setPid(rs.getInt("pid"));
            patient.setName(rs.getString("name"));
            patient.setAge(rs.getInt("age"));
            patient.setDisease(rs.getString("disease"));
            patient.setAddress(rs.getString("address"));

            return patient;
        }

        return null;
    }

    @Override
    public String updatePatient(Integer pid, String name, Integer age, String disease, String address)
            throws SQLException, ClassNotFoundException {

        Connection con = DBConnection.getConnection();

        String sql = "UPDATE patient SET name=?, age=?, disease=?, address=? WHERE pid=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, disease);
        ps.setString(4, address);
        ps.setInt(5, pid);

        int row = ps.executeUpdate();

        return (row == 1) ? "success" : "fail";
    }

    @Override
    public String deletePatient(Integer pid) throws SQLException, ClassNotFoundException {

        Connection con = DBConnection.getConnection();

        String sql = "DELETE FROM patient WHERE pid=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, pid);

        int row = ps.executeUpdate();

        return (row == 1) ? "success" : "fail";
    }
}