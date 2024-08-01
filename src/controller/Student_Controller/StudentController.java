package controller.Student_Controller;

import model.Student;
import service.Student_Service.IStudentService;
import service.Student_Service.StudentService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StudentController {
    private IStudentService studentService = new StudentService();
    private Scanner sc = new Scanner(System.in);

    public void display() {
        List<Student> students = studentService.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void editStudent() {
        System.out.print("Nhập ID của học viên cần chỉnh sửa: ");
        String id = sc.nextLine();

        Student existingStudent = studentService.findStudentById(id);
        if (existingStudent == null) {
            System.out.println("Không tìm thấy học viên có ID là " + id);
            return;
        }
        System.out.println("Thông tin học viên cần chỉnh sửa:");
        System.out.println(existingStudent);

        int choice;
        do {
            System.out.println("Chọn thông tin cần chỉnh sửa: \n" +
                    "1. Tên. \n" +
                    "2. Ngày sinh. \n" +
                    "3. Email. \n" +
                    "4. Số điện thoại. \n" +
                    "5. Lớp. \n" +
                    "6. Hoàn thành. \n"
            );
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Tên mới:");
                    String newName = sc.nextLine();
                    existingStudent.setName(newName);
                    break;
                case 2:
                    System.out.println("Ngày sinh mới:");
                    LocalDate newBirthday = null;
                    try {
                        newBirthday = LocalDate.parse(sc.nextLine());
                        existingStudent.setBirthday(newBirthday);
                    } catch (DateTimeParseException e) {
                        System.out.println("Định dạng ngày sinh không hợp lệ. Vui lòng nhập theo định dạng YYYY-MM-DD.");
                    }
                    break;
                case 3:
                    System.out.println("Email mới:");
                    String newEmail = sc.nextLine();
                    existingStudent.setEmail(newEmail);
                    break;
                case 4:
                    System.out.println("SĐT mới:");
                    String newPhoneNumber = sc.nextLine();
                    existingStudent.setPhoneNumber(newPhoneNumber);
                    break;
                case 5:
                    System.out.println("Lớp mới:");
                    String newClassName = sc.nextLine();
                    existingStudent.setClassName(newClassName);
                    break;
            }
        } while (choice != 6);
        studentService.updateStudent(id, existingStudent);
    }

    public void addStudent() {
        String id = "";
        do {
            System.out.println("Nhập id");
            id = sc.nextLine();
            System.out.println("ID hiện đang có xin vui lòng nhập ID khác");
        } while (studentService.findStudentById(id) != null);

        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        LocalDate birthday = null;
        do {
            try {
                System.out.print("Nhập ngày sinh: ");
                birthday = LocalDate.parse(sc.nextLine());
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Định dạng ngày sinh không hợp lệ. Vui lòng nhập theo định dạng YYYY-MM-DD.");
            }
        }while (true);
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        System.out.println("Nhập sdt: ");
        String phoneNumber = sc.nextLine();
        System.out.println("Nhập tên lớp: ");
        String className = sc.nextLine();

        Student student1 = new Student(id, name, birthday, email, phoneNumber, className);
        studentService.addStudent(student1);
    }

    public void deleteStudent() {
        System.out.print("Nhập ID của học viên cần xóa: ");
        String id = sc.nextLine();

        Student existingStudent = studentService.findStudentById(id);
        if (existingStudent == null) {
            System.out.println("Không tìm thấy học viên có ID là " + id);
            return;
        }
        System.out.println("Thông tin học viên cần xóa");
        System.out.println(existingStudent);
        if (studentService.deleteStudent(id)) {
            System.out.println("Xóa thành công");
        }
    }

    public void DisplayStudentFunctional() {
        int choice;
        do {
            System.out.println("Quản lý Codegym: \n" +
                    "1. Hiển thị danh sách học viên. \n" +
                    "2. Thêm mới học viên. \n" +
                    "3. Chỉnh sửa thông tin học viên. \n" +
                    "4. Xóa học viên. \n" +
                    "5. Go back menu. \n" +
                    "Xin chọn");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    display();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }
}
