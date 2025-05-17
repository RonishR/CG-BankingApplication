import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        Bank nationalizedBank = new NationalizedBank("SBI", "Central");
        Bank cooperativeBank = new CooperativeBank("CoopBank", "West");

        System.out.print("Enter number of accounts to create: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Account " + (i + 1) + ":");
            System.out.print("Choose bank (1 - Nationalized, 2 - Cooperative): ");
            int bankChoice = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter account type (1 - Savings, 2 - Current, 3 - Loan): ");
            int accountType = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter holder name: ");
            String holderName = scanner.nextLine();

            System.out.print("Enter initial balance: ");
            double balance = Double.parseDouble(scanner.nextLine());

            Account account = null;
            switch (accountType) {
                case 1 -> account = new SavingsAccount(holderName, balance);
                case 2 -> account = new CurrentAccount(holderName, balance);
                case 3 -> account = new LoanAccount(holderName, balance);
                default -> {
                    System.out.println("Invalid account type. Skipping this account.");
                    continue;
                }
            }

            if (bankChoice == 1) {
                nationalizedBank.openAccount(account);
            } else if (bankChoice == 2) {
                cooperativeBank.openAccount(account);
            } else {
                System.out.println("Invalid bank choice. Skipping this account.");
                continue;
            }

            accounts.add(account);
            System.out.println("Account created successfully.\n");
        }

        System.out.println("\n--- Account Details ---");
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
