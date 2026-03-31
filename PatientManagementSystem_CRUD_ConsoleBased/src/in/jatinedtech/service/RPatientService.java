package in.jatinedtech.service;

import in.jatinedtech.dto.Patient;

public interface RPatientService {

    public String addPatient(String name, Integer age, String disease, String address) throws Exception;

    public Patient searchPatient(Integer pid) throws Exception;

    public String updatePatient(Integer pid, String name, Integer age, String disease, String address) throws Exception;

    public String deletePatient(Integer pid) throws Exception;
}