package assigment.t2012e.model;

import assigment.t2012e.entity.Teacher;

import java.util.ArrayList;

public class TeacherModel {
    ArrayList<Teacher> list = new ArrayList<>();

    public boolean save(Teacher obj) {
        list.add(obj);
        return true;
    }

    public ArrayList<Teacher> findAll() {
        return list;
    }

    public Teacher findById(String id) {
        Teacher obj = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                obj = list.get(i);
                break;
            }
        }
        return obj;
    }
    public boolean update (String id, Teacher teacherUpdate){
        Teacher existingTeacher = findById(id);
        if (existingTeacher == null){
            return false;
        }
        existingTeacher.setFullName(teacherUpdate.getFullName());
        existingTeacher.setEmail(teacherUpdate.getEmail());
        existingTeacher.setPhone(teacherUpdate.getPhone());
        return true;
    }
    public boolean delete (String id){
        Teacher existingTeacher = findById(id);
        if (existingTeacher == null){
            return false;
        }
        list.remove(existingTeacher);
        return true;
    }
}
