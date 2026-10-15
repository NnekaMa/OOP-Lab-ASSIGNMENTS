public class CurrentAccount extends Account{
    private  double overDraft;
    private double monthlyFee;

    CurrentAccount(String accountNumber, double balance, double overDraft, double monthlyFee){
        super(accountNumber, balance);
        this.overDraft = overDraft;
        this.monthlyFee=monthlyFee;

    }
    @Override
    public void withdraw(double amount){
        if (amount <= 0){
            System.out.println("Amount must be positive!");
            return;
        }

        balance -=amount;
        System.out.println("Current Amount withdrawal successful:  $"  + amount);

    }
    @Override
    public void  endOfMonth(){
        balance -=monthlyFee;

        System.out.println("Current  "  + accountNumber +  ":Monthly fee  =$"  + monthlyFee  +
                ", New balance = $"  + balance);
    }
}
