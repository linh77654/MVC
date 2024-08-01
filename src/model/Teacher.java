package model;

import java.time.LocalDate;

public class Teacher extends Person{
    private String level;

    public Teacher(){}

    public Teacher(String id, String name, LocalDate birthday, String email, String phoneNumber, String level) {
        super(id, name, birthday, email, phoneNumber);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    public void teach(String subject) {
        System.out.println("Dạy môn " + subject);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "level='" + level + '\'' +
                "} " + super.toString();
    }
}
