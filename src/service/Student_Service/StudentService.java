package service.Student_Service;

import model.Student;
import repository.Student_Repo.IStudentRepo;
import repository.Student_Repo.StudentRepo;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepo studentRepo = new StudentRepo();

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public void addStudent(Student student) {
        studentRepo.addStudent(student);
    }

    @Override
    public void updateStudent(String id, Student updatedStudent) {
        studentRepo.updateStudent(id, updatedStudent);
    }

    @Override
    public Student findStudentById(String id) {
        return studentRepo.findStudentById(id);
    }

    @Override
    public boolean deleteStudent(String id) {
        return studentRepo.deleteStudent(id);
    }
}
