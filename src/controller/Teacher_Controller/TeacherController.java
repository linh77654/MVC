package controller.Teacher_Controller;

import model.Teacher;
import service.Teacher_Service.ITeacherService;
import service.Teacher_Service.TeacherService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class TeacherController {
    private ITeacherService teacherService = new TeacherService();
    private Scanner sc = new Scanner(System.in);

    public void display() {
        ArrayList<Teacher> teachers = teacherService.findAll();
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                System.out.println(teacher);
            }
        }
    }

    public void editTeacher() {
        System.out.println("Nhập id giảng viên cần chỉnh sửa: ");
        String id = sc.nextLine();

        Teacher existingTeacher = teacherService.findTeacherById(id);
        if (existingTeacher == null) {
            System.out.println("Không tìm thấy giảng viên co ID là: " + id);
            return;
        }

        System.out.println("Thông tin giảng viên cần chỉnh sửa");
        System.out.println(existingTeacher);

        int choice;
        do {
            System.out.println("Chọn thông tin cần chỉnh sửa: \n" +
                    "1. Tên. \n" +
                    "2. Ngày sinh. \n" +
                    "3. Email. \n" +
                    "4. Số điện thoại. \n" +
                    "5. Cấp bậc. \n" +
                    "6. Hoàn thành. \n"
            );
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Tên mới:");
                    String newName = sc.nextLine();
                    existingTeacher.setName(newName);
                    break;
                case 2:
                    System.out.println("Ngày sinh mới");
                    LocalDate newBirthday = null;
                    try {
                        newBirthday = LocalDate.parse(sc.nextLine());
                        existingTeacher.setBirthday(newBirthday);
                    } catch (DateTimeParseException e) {
                        System.out.println("Định dạng ngày sinh không hợp lệ. Vui lòng nhập theo định dạng YYYY-MM-DD. ");
                    }
                    break;
                case 3:
                    System.out.println("Email mới:");
                    String newEmail = sc.nextLine();
                    existingTeacher.setEmail(newEmail);
                    break;
                case 4:
                    System.out.println("SĐT mới:");
                    String newPhoneNumber = sc.nextLine();
                    existingTeacher.setPhoneNumber(newPhoneNumber);
                    break;
                case 5:
                    System.out.println("Cấp bậc mới:");
                    String newLevel = sc.nextLine();
                    existingTeacher.setLevel(newLevel);
                    break;
            }
        }
        while (choice != 6);
        teacherService.updateTeacher(id, existingTeacher);
    }

    public void addTeacher() {
        String id = "";
        do {
            System.out.println("Nhập id");
            id = sc.nextLine();
        } while (teacherService.findTeacherById(id) != null);

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
        String phone = sc.nextLine();
        System.out.println("Nhập cấp bậc: ");
        String level = sc.nextLine();

        Teacher teacher = new Teacher(id, name, birthday, email, phone, level);
        teacherService.addTeacher(teacher);
    }

    public void deleteTeacher() {
        System.out.println("Nhập id giảng viên cần xóa: ");
        String id = sc.nextLine();

        Teacher existingTeacher = teacherService.findTeacherById(id);
        if (existingTeacher == null) {
            System.out.println("Không tìm thấy giảng viên có ID là: " + id);
            return;
        }
        System.out.println("Thông tin giảng viên cần xóa");
        System.out.println(existingTeacher);
        if (teacherService.deleteTeacher(id)) {
            System.out.println("Xóa thành công");
        }
    }

    public void DisplayTeacherFunctional() {
        int choice;
        do {
            System.out.println("Quản lý Codegym: \n" +
                    "1. Hiển thị danh sách giảng viên. \n" +
                    "2. Thêm mới giảng viên. \n" +
                    "3. Chỉnh sửa thông tin giảng viên. \n" +
                    "4. Xóa giảng viên. \n" +
                    "5. Go back menu. \n" +
                    "Xin chọn");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    display();
                    break;
                case 2:
                    addTeacher();
                    break;
                case 3:
                    editTeacher();
                    break;
                case 4:
                    deleteTeacher();
                    break;
                case 5:
                    return;
            }
        }
        while (true);
    }
}
