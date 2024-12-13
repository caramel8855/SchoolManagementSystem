import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class StudentDatabase {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
        private static final String FILE_NAME = "students.dat";

    public static void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
            System.out.println("Student data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving student data: " + e.getMessage());
        }
    }
    
     public static void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (ArrayList<Student>) ois.readObject();
            System.out.println("Student data loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No student data file found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading student data: " + e.getMessage());
        }
    }

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

    public static void editStudentInfo(int rollNumber, String section) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber && student.getSection().equalsIgnoreCase(section)) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Editing student: " + student);
                System.out.print("Enter new name(Enter to skip): ");
                String newName = scanner.nextLine();
                student.setName(newName);

                System.out.print("Enter new class(Enter to skip): ");
                int newClass = scanner.nextInt();
                student.setStudentClass(newClass);

                System.out.print("Enter new section(enter to skip): ");
                scanner.nextLine(); 
                String newSection = scanner.nextLine();
                student.setSection(newSection);

                System.out.println("Student information updated successfully!");
                return;
            }
        }
        System.out.println("Student not found. Please check the roll number and section.");
    }

        public static void removeStudent(int rollNumber, String section) {
            for (Student student : students) {
                if (student.getRollNumber() == rollNumber && student.getSection().equalsIgnoreCase(section)) {
                    students.remove(student);
                    System.out.println("Student removed successfully!");
                    return;
                }
            }
            System.out.println("Student not found. Please double check the roll number and section.");
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
                return; 
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
