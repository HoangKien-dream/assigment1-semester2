package assigment.t2012e.controller;

import assigment.t2012e.entity.Student;
import assigment.t2012e.model.StudentModel;
import com.sun.media.sound.SoftVoice;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
    private StudentModel studentModel = new StudentModel();
    Scanner scr = new Scanner(System.in);

    public void create() {
        Student student = new Student();
        System.out.printf("Please enter student rollNumber: ");
        String rollNumber = scr.nextLine();
        student.setRollNumber(rollNumber);
        System.out.printf("Please enter student fullName: ");
        String fullName = scr.nextLine();
        student.setFullName(fullName);
        System.out.printf("Please enter student email: ");
        String email = scr.nextLine();
        student.setEmail(email);
        System.out.printf("Please enter student phone: ");
        String phone = scr.nextLine();
        student.setPhone(phone);
        if (studentModel.save(student)) {
            System.out.printf("Action Success!!");
        } else {
            System.out.printf("Action Failed");
        }
    }

    public void showList() {
        ArrayList<Student> list = studentModel.findAll();
        System.out.printf("%10s%10s%10s | %10s%15s%10s | %5s%20s%5s | %5s%10s%5s\n",
                "", "RollNumber", "",
                "", "FullName", "",
                "", "Email", "",
                "", "Phone", "");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    public void search() {
        System.out.printf("Enter student rollNumber: ");
        String rollNumber = scr.nextLine();
        Student student = studentModel.findById(rollNumber);
        if (student == null) {
            System.out.printf("Not Found\n");
        } else {
            System.out.printf("Found information student: %s\n", student.toString());
        }
    }

    public void update() {
        System.out.printf("Enter student rollNumber update: ");
        String rollNumber = scr.nextLine();
        Student student = studentModel.findById(rollNumber);
        if (student == null) {
            System.out.printf("Not Found\n");
        } else {
            System.out.printf("Found Student have rollNumber %s\n", rollNumber);
            Student updateStudent = new Student();
            System.out.printf("Please enter your new fullName:\n ");
            String fullName = scr.nextLine();
            updateStudent.setFullName(fullName);
            System.out.printf("Please enter your new phone:\n ");
            String phone = scr.nextLine();
            updateStudent.setPhone(phone);
            System.out.printf("Please enter your new email: \n");
            String email = scr.nextLine();
            updateStudent.setEmail(email);
            if (studentModel.update(rollNumber, updateStudent)) {
                System.out.printf("Update Success!!");
            } else {
                System.out.printf("Update Failed");
            }
        }
    }

    public void delete() {
        System.out.printf("Enter student rollNumber: ");
        String rollNumber = scr.nextLine();
        Student student = studentModel.findById(rollNumber);
        if (student == null) {
            System.out.printf("Not Found\n");
        } else {
            System.out.printf("Found Student have rollNumber %s\n", rollNumber);
            System.out.printf("Are you sure about delete student(Yes/No)\n");
            String choice = scr.nextLine();
            if (choice.equalsIgnoreCase("Yes")) {
                System.out.printf("Delete Success\n");
                studentModel.delete(rollNumber);
            } else {
                System.out.printf("Delete Failed");
            }
        }
    }
}
