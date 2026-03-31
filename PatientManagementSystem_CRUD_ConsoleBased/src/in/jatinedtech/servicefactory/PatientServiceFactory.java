package in.jatinedtech.servicefactory;

import in.jatinedtech.service.PatientServiceImpl;
import in.jatinedtech.service.RPatientService;

// Factory class to provide Service object (Singleton Pattern)
public class PatientServiceFactory {

    // Private constructor (to prevent object creation)
    private PatientServiceFactory() {
    }

    private static RPatientService patientService = null;

    public static RPatientService getPatientService() {

        // Singleton Design Pattern
        if (patientService == null) {
            patientService = new PatientServiceImpl();
        }

        return patientService;
    }
}