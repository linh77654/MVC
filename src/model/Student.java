package model;

import java.time.LocalDate;

public class Student {
    private String id;
    private String name;
    private LocalDate birthday;
    private String email;
    private String phoneNumber;
    private String className;

    // Constructor
    public Student(String id, String name, LocalDate birthday, String email, String phoneNumber, String className) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.className = className;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    // Phương thức chuyển đổi thông tin thành chuỗi CSV
    public String getInfoToCSV() {
        return String.join(",", id, name, birthday.toString(), email, phoneNumber, className);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
