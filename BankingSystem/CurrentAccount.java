public class CurrentAccount extends BankingSystem {

    public CurrentAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount + ". Remaining balance: ₹" + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}
