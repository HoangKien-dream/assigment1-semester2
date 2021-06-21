package assigment.t2012e.view;

import assigment.t2012e.controller.StudentController;
import assigment.t2012e.entity.Student;

import java.util.Scanner;

public class StudentMenu {
    private StudentController studentController = new StudentController();
    Scanner scanner = new Scanner(System.in);

    public void generateStudentMenu() {
        while (true) {
            System.out.printf("Student Manager\n");
            System.out.printf("--------------------\n");
            System.out.printf("1. Create new student.\n");
            System.out.printf("2. Show list student.\n");
            System.out.printf("3. Update student.\n");
            System.out.printf("4. Delete student.\n");
            System.out.printf("5. Search student.\n");
            System.out.printf("6. Back Program.\n");
            System.out.printf("--------------------\n");
            System.out.printf("Please enter your choice (1-6): \n");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    studentController.create();
                    break;
                case 2:
                    studentController.showList();
                    break;
                case 3:
                    studentController.update();
                    break;
                case 4:
                    studentController.delete();
                    break;
                case 5:
                    studentController.search();
                    break;
                case 6:
                    System.out.printf("Exit program");
                    break;
                default:
                    break;
            }
            if (choice == 6){
                break;
            }
            scanner.nextLine();
        }
    }
}
