import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankingSystem account;

        System.out.println("Choose account type (1. Savings  2. Current): ");
        int type = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        if (type == 1)
            account = new Savingsaccount(accNo, name, bal);
        else
            account = new CurrentAccount(accNo, name, bal);

        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Show Details\n4. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double d = sc.nextDouble();
                    account.deposit(d);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double w = sc.nextDouble();
                    account.withdraw(w);
                    break;
                case 3:
                    account.displayDetails();
                    break;
                case 4:
                    System.out.println("Thank you for banking with us.");
                    System.exit(0);
            }
        }
    }
}

