import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDatabase.loadFromFile();
        TeacherDatabase.loadFromFile();
        Scanner scanner = new Scanner(System.in);
        int choice;        

        do {
            System.out.println("\nWelcome to the School Management System");
            System.out.println("Login as: ");
            System.out.println("1. Admin");
            System.out.println("2. Teacher");
            System.out.println("3. Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    AdminMenu.adminMenu();
                    break;
                case 2:
                    TeacherMenu.teacherMenu();
                    break;
                case 3:
                    StudentMenu.studentMenu();
                    break;
                case 4:
                StudentDatabase.saveToFile();
                TeacherDatabase.saveToFile();
                System.out.println("Exiting program. Data saved!");
                return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);
    }
}