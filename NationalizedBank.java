// NationalizedBank.java
public class NationalizedBank extends Bank {
    public NationalizedBank(String bankName, String branchName) {
        super(bankName, branchName);
    }

    @Override
    public void openAccount(Account account) {
        System.out.println("Account opened in Nationalized Bank.");
    }

    @Override
    public void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Branch: " + branchName);
        System.out.println("Bank Code: " + getBankCode());
    }
}