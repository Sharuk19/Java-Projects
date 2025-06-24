public class Teacher extends Person{
    private String subject;
    private int regno;
    private double salary;

    public Teacher(String name, int age, String subject, int regno, double salary){
        super(name, age);
        this.subject = subject;
        this.regno = regno;
        this.salary=salary;
    }

    @Override
    public void showdetails() {
        System.out.println("Name:-"+" "+name);
        System.out.println("Age:-"+" "+age);
        System.out.println("Regno:-"+" "+regno);
        System.out.println("Subject"+" "+subject);
        System.out.println("Salary"+" "+salary);
    }
}
