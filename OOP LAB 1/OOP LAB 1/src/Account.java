 // Abstract class: shared state and concrete methods, plus abstract methods
abstract class Account6 {
    protected double balance;

    // Concrete method: written once, inherited by all accounts
    void deposit(double amount) { balance += amount; }

    // Abstract method: each account type decides its own fee
    abstract double monthlyFee();
}

class SavingsAccount6 extends Account6 {
    @Override double monthlyFee() { return 5; }
}

class CurrentAccount6 extends Account6 {
    @Override double monthlyFee() { return 20; }
}

class AccountDemo {
    public static void main(String[] args) {
        Account6[] accounts = { new SavingsAccount6(), new CurrentAccount6() };

        for (Account6 a : accounts) {
            a.deposit(1000);   // inherited concrete method
            System.out.println("Balance: " + a.balance + ", fee: " + a.monthlyFee());
        }
    }
}

