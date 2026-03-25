package in.biduaedtech.controller;

import java.util.Scanner;

import in.biduaedtech.dto.Student;
import in.biduaedtech.service.RStudentService;
import in.biduaedtech.servicefactory.StudentServiceFactory;

public class TestApp {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		// Connection con = DriverManager.getConncetion(url, username, password);
		RStudentService studentservice = StudentServiceFactory.getStudentService();

		while (true) {
			System.out.println("====== STUDENT MANAGMENT SYSTEM ======");
			System.out.println("1. Add Student");
			System.out.println("2. Search Student");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit Student");

			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				// Add student
				sc.nextLine(); 

				System.out.print("Enter name: ");
				String name = sc.nextLine();

				System.out.print("Enter age: ");
				int age = sc.nextInt();
				sc.nextLine(); 

				System.out.print("Enter address: ");
				String address = sc.nextLine();

				String result = studentservice.addStudent(name, age, address);

				if (result.equals("success")) {
					System.out.println("Student added successfully");
				} else {
					System.out.println("Student insertion failed");
				}
				break;
			case 2:
				// Search student
				System.out.print("Enter student ID: ");
				Integer sid = sc.nextInt();
				String student = studentservice.searchStudent(sid);
				if (student != null) {
					System.out.println(student);
				} else {
					System.out.println("Student not found");
				}
				break;

			case 3:
				// Update student
				System.out.print("Enter Student ID:");
				Integer newSid = sc.nextInt();
				System.out.print("Enter New Name:");
				String newName = sc.next();
				System.out.print("Enter New Age:");
				Integer newAge = sc.nextInt();
				System.out.print("Enter New Address:");
				String newAddress = sc.next();

				String status = studentservice.updateStudent(newSid, newName, newAge, newAddress);
				if (status.equals("success")) {
					System.out.println("Student updated successfully");
				} else {
					System.out.println("Studetn update failed");
				}
				break;

			case 4:
				// Delete student
				System.out.print("Enter student id to delete: ");
				Integer deletedID = sc.nextInt();

				String deletedResult = studentservice.deleteStudent(deletedID);

				if (deletedResult.equals("success")) {
					System.out.println("Student deleted sucessfully");
				} else {
					System.out.println("Student not found");
				}
				break;

			case 5:
				System.out.println("Application closed.");
				sc.close();
				System.exit(0);

			default:
				System.out.println("Invalid choice. Try Again.");
			}
		}

	}

}