package repository.Student_Repo;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public interface IStudentRepo {
    List<Student> findAll();
    void addStudent(Student student);
    void updateStudent(String id, Student updatedStudent);
    Student findStudentById(String id);
    boolean deleteStudent(String id);
}
