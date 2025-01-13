package week05.example01;

public class BankAccount2 {
    private static int count = 100;
    private int accountNumber;
    private String customerName;
    private double accountBalance;

    public double getAccountBalance() {
        return accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    {
        accountNumber = count++;
    }

    private BankAccount2(String customerName, double accountBalance) {
        this.customerName = customerName;
        this.accountBalance = accountBalance;
    }

    private BankAccount2(String customerName) {
        this(customerName, 0);
    }

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public void withdraw(double amount) {
        if (accountBalance >= amount)
            accountBalance -= amount;
        else
            System.out.println("출금 잔액 부족");
    }

    public void transfer(BankAccount2 account, double amount) {
        if (accountBalance >= amount) {
            accountBalance -= amount;
            account.accountBalance += amount;
        } else
            System.out.println("출금 잔액 부족");
    }

    public void showAccount() {
        System.out.println("-".repeat(20));
        System.out.println("고객이름 : " + customerName);
        System.out.println("계좌번호 : " + accountNumber);
        System.out.println("잔   액 : " + accountBalance);
        System.out.println("-".repeat(20));
    }

    @Override
    public String toString() {
        return "고객이름 : " + customerName +
                "\n 계좌번호 : " + accountNumber +
                "\n 잔   액 : " + accountBalance + "\n";
    }

    public static BankAccount2 getInstance(String name, double amount) {
        return new BankAccount2(name, amount);
    }
}
