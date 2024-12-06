import java.util.Scanner;

public class AdminMenu {
    public static void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. View All Students");
            System.out.println("4. View All Teachers");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    StudentDatabase.addStudent();
                    break;
                case 2:
                    TeacherDatabase.addTeacher();
                    break;
                case 3:
                    StudentDatabase.viewAllStudents();
                    break;
                case 4:
                    TeacherDatabase.viewAllTeachers();
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    return; // Return to Main Menu
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (true);
    }
}
