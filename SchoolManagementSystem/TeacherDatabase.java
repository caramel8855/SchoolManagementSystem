import java.util.ArrayList;
import java.util.Scanner;

public class TeacherDatabase {
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void addTeacher() {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter teacher ID: ");
        int teacherId = scanner.nextInt();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();

        teachers.add(new Teacher(name, age, teacherId, salary));
        System.out.println("Teacher added successfully!");
    }

    public static void viewAllTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers to display.");
            return;
        }
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
}
