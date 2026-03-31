package in.jatinedtech.service;

import in.jatinedtech.daofactory.PatientDaoFactory;
import in.jatinedtech.dto.Patient;
import in.jatinedtech.persistance.RPatientDao;

public class PatientServiceImpl implements RPatientService {

    private RPatientDao patientDao;

    @Override
    public String addPatient(String name, Integer age, String disease, String address) throws Exception {

        // 🔥 Validation (IMPORTANT FOR INTERVIEW)
        if (name == null || name.trim().isEmpty()) {
            return "Name cannot be empty";
        }

        if (age == null || age <= 0) {
            return "Invalid age";
        }

        if (disease == null || disease.trim().isEmpty()) {
            return "Disease cannot be empty";
        }

        if (address == null || address.trim().isEmpty()) {
            return "Address cannot be empty";
        }

        patientDao = PatientDaoFactory.getPatientDao();
        return patientDao.addPatient(name, age, disease, address);
    }

    @Override
    public Patient searchPatient(Integer pid) throws Exception {

        if (pid == null || pid <= 0) {
            return null;
        }

        patientDao = PatientDaoFactory.getPatientDao();
        return patientDao.searchPatient(pid);
    }

    @Override
    public String updatePatient(Integer pid, String name, Integer age, String disease, String address)
            throws Exception {

        if (pid == null || pid <= 0) {
            return "Invalid Patient ID";
        }

        if (name == null || name.trim().isEmpty()) {
            return "Name cannot be empty";
        }

        if (age == null || age <= 0) {
            return "Invalid age";
        }

        if (disease == null || disease.trim().isEmpty()) {
            return "Disease cannot be empty";
        }

        if (address == null || address.trim().isEmpty()) {
            return "Address cannot be empty";
        }

        patientDao = PatientDaoFactory.getPatientDao();
        return patientDao.updatePatient(pid, name, age, disease, address);
    }

    @Override
    public String deletePatient(Integer pid) throws Exception {

        if (pid == null || pid <= 0) {
            return "Invalid Patient ID";
        }

        patientDao = PatientDaoFactory.getPatientDao();
        return patientDao.deletePatient(pid);
    }
}