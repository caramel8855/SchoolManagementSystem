import java.io.Serializable;

public class Teacher implements Serializable {
    private String name;
    private int age;
    private int teacherId;
    private double salary;

    public Teacher(String name, int age, int teacherId, double salary) {
        this.name = name;
        this.age = age;
        this.teacherId = teacherId;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{name='" + name + "', age=" + age +
               ", teacherId=" + teacherId + ", salary=" + salary + "}";
    }
}
