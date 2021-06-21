package assigment.t2012e.controller;


import assigment.t2012e.entity.Teacher;
import assigment.t2012e.model.TeacherModel;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherController {
    private TeacherModel teacherModel = new TeacherModel();
    Scanner scr = new Scanner(System.in);

    public void create() {
        Teacher teacher = new Teacher();
        System.out.printf("Please enter your id: \n");
        String id = scr.nextLine();
        teacher.setId(id);
        System.out.printf("Please enter your fullName: \n");
        String name = scr.nextLine();
        teacher.setFullName(name);
        System.out.printf("Please enter your phone: \n");
        String phone = scr.nextLine();
        teacher.setPhone(phone);
        System.out.printf("Please enter your email: \n");
        String email = scr.nextLine();
        teacher.setEmail(email);
        if (teacherModel.save(teacher)) {
            System.out.printf("Action Success!!\n");
        } else {
            System.out.printf("Action Failed\n");
        }
    }

    public void showList() {
        ArrayList<Teacher> list = teacherModel.findAll();
        System.out.printf("%10s%10s%10s | %10s%15s%10s | %5s%20s%5s | %5s%10s%5s\n",
                "", "ID", "",
                "", "FullName", "",
                "", "Email", "",
                "", "Phone", "");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf(list.get(i).toString());
        }
    }

    public void search() {
        System.out.printf("Please enter your Id: \n");
        String id = scr.nextLine();
        Teacher teacher = teacherModel.findById(id);
        if (teacher == null) {
            System.out.printf("Not Found");
        } else {
            System.out.printf("Information teacher: %s", teacher.toString());
        }
    }

    public void update() {
        Teacher teacherUpdate = new Teacher();
        System.out.printf("Please enter your Id: \n");
        String id = scr.nextLine();
        Teacher teacher = teacherModel.findById(id);
        if (teacher == null) {
            System.out.printf("Not Found\n");
        } else {
            System.out.printf("Find teacher have id %s: \n ", id);
            System.out.printf("Please enter your new name: \n");
            String name = scr.nextLine();
            teacherUpdate.setFullName(name);
            System.out.printf("Please enter your new phone: \n");
            String phone = scr.nextLine();
            teacherUpdate.setPhone(phone);
            System.out.printf("Please enter your new email: \n");
            String email = scr.nextLine();
            teacherUpdate.setEmail(email);
            if (teacherModel.update(id, teacherUpdate)) {
                System.out.printf("Update Success!!\n");
            } else {
                System.out.printf("Update Failed\n");
            }
        }
    }

    public void delete() {
        System.out.printf("Please enter your Id: \n");
        String id = scr.nextLine();
        Teacher teacher = teacherModel.findById(id);
        if (teacher == null) {
            System.out.printf("Not Found\n");
        }else {
            System.out.printf("Find teacher have id %s: \n", id);
            System.out.printf("Are you sure delete teacher(Yes/No):\n ");
            String choice = scr.nextLine();
            if (choice.equalsIgnoreCase("Yes")){
                teacherModel.delete(id);
                System.out.printf("Delete Success!!\n");
            }else {
                System.out.printf("Delete Failed\n");
            }
        }
    }
}
