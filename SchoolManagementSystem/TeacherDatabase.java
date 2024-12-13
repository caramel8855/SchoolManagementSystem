import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TeacherDatabase {
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
        private static final String FILE_NAME = "teachers.dat";

     public static void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(teachers);
            System.out.println("Teacher data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving teacher data: " + e.getMessage());
        }
    }

     public static void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            teachers = (ArrayList<Teacher>) ois.readObject();
            System.out.println("Teacher data loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No teacher data file found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading teacher data: " + e.getMessage());
        }
    }


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
