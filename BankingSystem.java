public abstract class BankingSystem {
  protected int accountNumber;
  protected String holderName;
  protected double balance;

  public BankingSystem(int accountNumber, String holderName, double balance) {
    this.accountNumber = accountNumber;
    this.holderName = holderName;
    this.balance = balance;
  }

  public void deposit(double amount) {
    balance += amount;
    System.out.println("Deposited ₹" + amount + ". New balance: ₹" + balance);
  }

  public void displayDetails() {
    System.out.println("Account No: " + accountNumber);
    System.out.println("Holder Name: " + holderName);
    System.out.println("Balance: ₹" + balance);
  }

  public abstract void withdraw(double amount);
}