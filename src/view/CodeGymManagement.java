package view;

import controller.Student_Controller.StudentController;
import controller.Teacher_Controller.TeacherController;

import java.util.Scanner;

public class CodeGymManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentController studentController = new StudentController();
        TeacherController teacherController = new TeacherController();

        int choice;
        do {
            System.out.println("Quản lý Codegym: \n" +
                    "1. Quản lý học viên. \n" +
                    "2. Quản lý giảng viên. \n" +
                    "3. Exit. \n" +
                    "Xin chọn");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    studentController.DisplayStudentFunctional();
                    break;
                case 2:
                    teacherController.DisplayTeacherFunctional();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }
}
