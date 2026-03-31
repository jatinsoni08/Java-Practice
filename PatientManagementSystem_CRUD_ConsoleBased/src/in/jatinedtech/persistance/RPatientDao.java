package in.jatinedtech.persistance;

import java.sql.SQLException;

import in.jatinedtech.dto.Patient;

public interface RPatientDao {

    public String addPatient(String name, Integer age, String disease, String address)
            throws SQLException, ClassNotFoundException;

    public Patient searchPatient(Integer pid)
            throws SQLException, ClassNotFoundException;

    public String updatePatient(Integer pid, String name, Integer age, String disease, String address)
            throws SQLException, ClassNotFoundException;

    public String deletePatient(Integer pid)
            throws SQLException, ClassNotFoundException;
}