public class Student {
    private String name;
    private int rollNumber;
    private String section;
    private int studentClass;
    private String grade;

    public Student(String name, int rollNumber, String section, int studentClass) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.section = section;
        this.studentClass = studentClass;
        this.grade = "Not Assigned";
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getSection() {
        return section;
    }

    public int getStudentClass() {
        return studentClass;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', rollNumber=" + rollNumber +
               ", section='" + section + "', class=" + studentClass +
               ", grade='" + grade + "'}";
    }
}
