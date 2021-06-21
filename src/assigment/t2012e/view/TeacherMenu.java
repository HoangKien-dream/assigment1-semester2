package assigment.t2012e.view;

import assigment.t2012e.controller.TeacherController;
import assigment.t2012e.entity.Teacher;

import java.util.Scanner;

public class TeacherMenu {
    public void generateTeacher() {
        Scanner scanner = new Scanner(System.in);
        TeacherController teacherController = new TeacherController();
        while (true) {
            System.out.printf("Teacher Manager\n");
            System.out.printf("---------------------\n");
            System.out.printf("1. Create new teacher.\n");
            System.out.printf("2. Show list teacher.\n");
            System.out.printf("3. Update teacher.\n");
            System.out.printf("4. Delete teacher.\n");
            System.out.printf("5. Search teacher.\n");
            System.out.printf("6. Back Program.\n");
            System.out.printf("--------------------\n");
            System.out.printf("Please enter your choice (1-6): \n");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    teacherController.create();
                    break;
                case 2:
                    teacherController.showList();
                    break;
                case 3:
                    teacherController.update();
                    break;
                case 4:
                    teacherController.delete();
                    break;
                case 5:
                    teacherController.search();
                    break;
                case 6:
                    System.out.printf("Exit Program");
            }
            if (choice == 6) {
                break;
            }
            scanner.nextLine();
        }
    }
}
