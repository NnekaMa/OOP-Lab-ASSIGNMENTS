import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// NEW: checked exception thrown when a withdrawal is too large
class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) {
        super(message);
    }
}

public class BankAccount {
    private double balance;
    private List<String> history = new ArrayList<>();

    public void deposit(double amount) {
        balance += amount;
        history.add("Deposited " + amount);
    }

    // ORIGINAL (Lab 3): returned false when the balance was too low
    // public boolean withdraw(double amount) {
    //     if (amount > balance) {
    //         return false;
    //     }
    //     balance -= amount;
    //     history.add("Withdrew " + amount);
    //     return true;
    // }

    // MODIFIED: now returns void and throws an exception instead of returning false
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Cannot withdraw " + amount + ": balance is only " + balance);
        }
        balance -= amount;
        history.add("Withdrew " + amount);
    }

    public double getBalance() {
        return balance;
    }

    // Unmodifiable copy: callers can read it but not change it
    public List<String> getHistory() {
        return Collections.unmodifiableList(new ArrayList<>(history));
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.deposit(500);
        System.out.println(acc.getHistory());   // [Deposited 500.0]

        try {
            acc.getHistory().add("Hacked");     // blocked
        } catch (UnsupportedOperationException e) {
            System.out.println("History cannot be modified");
        }

        // The caller must now handle the exception (try/catch is required)
        try {
            acc.withdraw(200);                  // succeeds
            System.out.println("Balance: " + acc.getBalance());
            acc.withdraw(1000);                 // throws
        } catch (InsufficientFundsException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println(acc.getHistory());
    }
}