import java.util.ArrayList;

public class School {
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("✅ Student added.");
    }

    public void addTeacher(Teacher t) {
        teachers.add(t);
        System.out.println("✅ Teacher added.");
    }

    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("❗ No students added yet.");
        } else {
            for (Student s : students) {
                s.showdetails();
                System.out.println("------------");
            }
        }
    }

    public void showAllTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("❗ No teachers added yet.");
        } else {
            for (Teacher t : teachers) {
                t.showdetails();
                System.out.println("------------");
            }
        }
    }
}
