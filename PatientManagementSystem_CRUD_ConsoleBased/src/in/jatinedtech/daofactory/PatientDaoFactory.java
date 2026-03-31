package in.jatinedtech.daofactory;

import in.jatinedtech.persistance.PatientDaoImpl;
import in.jatinedtech.persistance.RPatientDao;

public class PatientDaoFactory {

    // private constructor (Singleton style)
    private PatientDaoFactory() {

    }

    private static RPatientDao patientDao = null;

    public static RPatientDao getPatientDao() {

        if (patientDao == null) {
            patientDao = new PatientDaoImpl();
        }

        return patientDao;
    }
}