package assigment.t2012e;

import assigment.t2012e.entity.Student;
import assigment.t2012e.view.StudentMenu;
import assigment.t2012e.view.TeacherMenu;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Scanner;

public class T2012EApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentMenu studentMenu = new StudentMenu();
        TeacherMenu teacherMenu = new TeacherMenu();
       while (true){
           System.out.printf("*****Manager*****\n");
           System.out.printf("1. Student Manager\n");
           System.out.printf("2. Teacher Manager\n");
           System.out.printf("3.Exit Program\n");
           System.out.printf("Please enter your choice (1-3): \n");
           int choice = scanner.nextInt();
           scanner.nextLine();
           switch (choice) {
               case 1:
                   studentMenu.generateStudentMenu();
                   break;
               case 2:
                   teacherMenu.generateTeacher();
                   break;
               case 3:
                   System.out.printf("Exit Program");
                   break;
           }
           if (choice == 3) {
               break;
           }
       }
    }
}
