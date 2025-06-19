public class SavingsAccount extends BankingSystem {

    public SavingsAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= 1000) { // Minimum balance check
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount + ". Remaining balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance. Minimum ₹1000 required.");
        }
    }
}

