package repository.Teacher_Repo;

import model.Teacher;
import java.util.ArrayList;

public interface ITeacherRepo {
    ArrayList<Teacher> findAll();
    void addTeacher(Teacher teacher);
    void updateTeacher(String id, Teacher updatedTeacher);
    Teacher findTeacherById(String id);
    boolean deleteTeacher(String id);
}
