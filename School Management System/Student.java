public class Student extends Person {
    private int rollno;
    private String grade;

    public Student(String name, int age, int rollno, String grade) {
        super(name, age);
        this.rollno = rollno;
        this.grade = grade;
    }

    @Override
    public void showdetails() {
        System.out.println("Name:-"+" "+name);
        System.out.println("Age:-"+" "+age);
        System.out.println("Roll No:-"+" "+rollno);
        System.out.println("Grade:-"+" "+grade);
    }
}

