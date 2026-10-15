import  java.util.ArrayList;
import  java.util.List;

public class BankDemo {
    public static void  main(String[] args){
        List<Account> accounts = new ArrayList<>();



        accounts.add(new SavingsAccount("NEA810" , 1000, 100,0.02));
        accounts.add(new CurrentAccount("NEA810" , 1000, 100,0.02));

        System.out.println("INITIAL BALANCE");

        for (Account account : accounts){
            System.out.println(account.accountNumber + "Balance: $"  + account.getBalance());
        }
        System.out.println("\n NORMAL TRANSACTIONS");

        accounts.get(0).withdraw(300);


        accounts.get(1).withdraw(800);


        System.out.println("\n EDGE CASE 1: SAVINGS WITHDRAW REJECTED");


        accounts.get(1).withdraw(850);

        System.out.println("\n EDGE CASE 2: CURRENT WITHDRAW REJECTED");

        accounts.get(1).withdraw(200);

        System.out.println("\n END OF MONTH");




        for (Account account : accounts){
            System.out.println("\nProcessing account:"  + account.accountNumber);



            account.endOfMonth();

            System.out.println("Final balance:  $"  + account.getBalance());
        }
    }
}
