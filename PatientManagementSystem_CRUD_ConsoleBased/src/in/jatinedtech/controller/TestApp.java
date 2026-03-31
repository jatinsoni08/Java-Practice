package in.jatinedtech.controller;

import java.util.Scanner;

import in.jatinedtech.dto.Patient;
import in.jatinedtech.service.RPatientService;
import in.jatinedtech.servicefactory.PatientServiceFactory;

public class TestApp {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        RPatientService patientService = PatientServiceFactory.getPatientService();

        while (true) {

            System.out.println("====== PATIENT MANAGEMENT SYSTEM ======");
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:
                // Add Patient
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Disease: ");
                String disease = sc.nextLine();

                System.out.print("Enter Address: ");
                String address = sc.nextLine();

                String result = patientService.addPatient(name, age, disease, address);

                if (result.equals("success")) {
                    System.out.println("Patient added successfully");
                } else {
                    System.out.println("Patient insertion failed");
                }
                break;

            case 2:
                // Search Patient
                System.out.print("Enter Patient ID: ");
                Integer pid = sc.nextInt();

                Patient patient = patientService.searchPatient(pid);

                if (patient != null) {
                    System.out.println("Patient ID: " + patient.getPid());
                    System.out.println("Name: " + patient.getName());
                    System.out.println("Age: " + patient.getAge());
                    System.out.println("Disease: " + patient.getDisease());
                    System.out.println("Address: " + patient.getAddress());
                } else {
                    System.out.println("Patient not found");
                }
                break;

            case 3:
                // Update Patient
                System.out.print("Enter Patient ID: ");
                Integer newPid = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Name: ");
                String newName = sc.nextLine();

                System.out.print("Enter New Age: ");
                Integer newAge = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Disease: ");
                String newDisease = sc.nextLine();

                System.out.print("Enter New Address: ");
                String newAddress = sc.nextLine();

                String status = patientService.updatePatient(newPid, newName, newAge, newDisease, newAddress);

                if (status.equals("success")) {
                    System.out.println("Patient updated successfully");
                } else {
                    System.out.println("Patient update failed");
                }
                break;

            case 4:
                // Delete Patient
                System.out.print("Enter Patient ID to delete: ");
                Integer deleteId = sc.nextInt();

                String deleteResult = patientService.deletePatient(deleteId);

                if (deleteResult.equals("success")) {
                    System.out.println("Patient deleted successfully");
                } else {
                    System.out.println("Patient not found");
                }
                break;

            case 5:
                System.out.println("Application closed.");
                sc.close();
                System.exit(0);

            default:
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}