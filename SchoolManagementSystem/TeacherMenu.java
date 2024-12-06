import java.util.Scanner;

public class TeacherMenu {
    public static void teacherMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nTeacher Menu:");
            System.out.println("1. View All Students");
            System.out.println("2. Search Student");
            System.out.println("3. Add Grade to Student");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    StudentDatabase.viewAllStudents();
                    break;
                case 2:
                    StudentDatabase.searchStudent();
                    break;
                case 3:
                    StudentDatabase.addGrade();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...");
                    return; 
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (true);
    }
}
