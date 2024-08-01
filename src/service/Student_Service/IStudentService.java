package service.Student_Service;

import model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void addStudent(Student student);
    void updateStudent(String id, Student updateStudent);
    Student findStudentById(String id);
    boolean deleteStudent(String id);
}
