import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        School school = new School();

        while (true) {
            System.out.println("\n🏫 SCHOOL MANAGEMENT MENU");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Show All Students");
            System.out.println("4. Show All Teachers");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // flush

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String sName = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int sAge = sc.nextInt();
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine(); // flush
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();
                    school.addStudent(new Student(sName, sAge, roll, grade));
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    String tName = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int tAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Subject: ");
                    String subject = sc.nextLine();
                    System.out.println("Enter Reg no: ");
                    int regno = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    school.addTeacher(new Teacher(tName, tAge, subject, regno, salary));
                    break;

                case 3:
                    school.showAllStudents();
                    break;

                case 4:
                    school.showAllTeachers();
                    break;

                case 5:
                    System.out.println("👋 Exiting. Thank you!");
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
