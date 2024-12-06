import java.util.Scanner;

public class StudentMenu {
    public static void studentMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your roll number: ");
        int rollNumber = scanner.nextInt();

        StudentDatabase.viewPersonalInfo(rollNumber);

        System.out.println("Returning to Main Menu...");
        return; 
    }
}
