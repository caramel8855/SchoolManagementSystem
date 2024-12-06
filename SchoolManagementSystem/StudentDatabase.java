import java.util.ArrayList;
import java.util.Scanner;

public class StudentDatabase {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        System.out.print("Enter section: ");
        String section = scanner.next();
        System.out.print("Enter class: ");
        int studentClass = scanner.nextInt();

        students.add(new Student(name, rollNumber, section, studentClass));
        System.out.println("Student added successfully!");
    }

    public static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void searchStudent() {
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        System.out.print("Enter section: ");
        String section = scanner.next();
        System.out.print("Enter class: ");
        int studentClass = scanner.nextInt();

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber &&
                student.getSection().equalsIgnoreCase(section) &&
                student.getStudentClass() == studentClass) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void addGrade() {
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        System.out.print("Enter section: ");
        String section = scanner.next();
    
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber && student.getSection().equalsIgnoreCase(section)) {
                System.out.print("Enter grade (A, A+, B, etc.): ");
                String grade = scanner.next();
                student.setGrade(grade);
                System.out.println("Grade added successfully for student: " + student);
                return; // Exit the method after updating
            }
        }
        System.out.println("Student not found. Please check the roll number and section.");
    }
    

    public static void viewPersonalInfo(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
