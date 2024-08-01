package service.Teacher_Service;

import model.Teacher;
import repository.Teacher_Repo.ITeacherRepo;
import repository.Teacher_Repo.TeacherRepo;


import java.util.ArrayList;

public class TeacherService implements ITeacherService {
    private ITeacherRepo teacherRepo = new TeacherRepo();

    @Override
    public ArrayList<Teacher> findAll() {
        return teacherRepo.findAll();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherRepo.addTeacher(teacher);
    }

    @Override
    public void updateTeacher(String id, Teacher updatedTeacher) {
        teacherRepo.updateTeacher(id, updatedTeacher);
    }

    @Override
    public Teacher findTeacherById(String id) {
        return teacherRepo.findTeacherById(id);
    }

    @Override
    public boolean deleteTeacher(String id) {
        return teacherRepo.deleteTeacher(id);
    }
}
