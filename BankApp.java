// BankApp.java (Main Class)
import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        Bank nationalizedBank = new NationalizedBank("SBI", "Central");
        Bank cooperativeBank = new CooperativeBank("CoopBank", "West");

        Account savingsAccount = new SavingsAccount("Rahul", 8500);
        nationalizedBank.openAccount(savingsAccount);
        accounts.add(savingsAccount);

        Account currentAccount = new CurrentAccount("John", 5000);
        cooperativeBank.openAccount(currentAccount);
        accounts.add(currentAccount);

        Account loanAccount = new LoanAccount("Rita", 10000);
        cooperativeBank.openAccount(loanAccount);
        accounts.add(loanAccount);

        for (Account account : accounts) {
            account.showAccountType();
            System.out.println("Account Number: " + account.accountNumber);
            System.out.println("Holder: " + account.holderName);
            System.out.println("Balance: " + account.getBalance());
            System.out.println("---");
        }

        scanner.close();
    }
}
