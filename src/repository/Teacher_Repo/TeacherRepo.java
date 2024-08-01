package repository.Teacher_Repo;

import model.Teacher;

import java.util.ArrayList;
import java.time.LocalDate;

public class TeacherRepo implements ITeacherRepo {
    private static ArrayList<Teacher> list;

    static {
        list = new ArrayList<>();
        Teacher t1 = new Teacher("1", "Nguyen Hoang Linh", LocalDate.parse("1985-02-03"), "linh@gmail.com", "0911144422", "Senior");
        Teacher t2 = new Teacher("2", "Hieu Hoang Tinh", LocalDate.parse("1987-02-03"), "Hieu@gmail.com", "0911133322", "Junior");
        list.add(t1);
        list.add(t2);
    }

    @Override
    public ArrayList<Teacher> findAll() {
        return list;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        list.add(teacher);
    }

    @Override
    public void updateTeacher(String id, Teacher updatedTeacher) {
        for (Teacher teacher : list) {
            if (teacher.getId().equals(id)) {
                teacher.setName(updatedTeacher.getName());
                teacher.setBirthday(updatedTeacher.getBirthday());
                teacher.setEmail(updatedTeacher.getEmail());
                teacher.setPhoneNumber(updatedTeacher.getPhoneNumber());
                teacher.setLevel(updatedTeacher.getLevel());
                return;
            }
        }
    }

    @Override
    public Teacher findTeacherById(String id) {
        for (Teacher teacher : list) {
            if (teacher.getId().equals(id)) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public boolean deleteTeacher(String id) {
        for (Teacher teacher : list) {
            if (teacher.getId().equals(id)) {
                list.remove(teacher);
                return true;
            }
        }
        return false;
    }
}
