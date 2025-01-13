package week05.lab01;

/**
 * 05주차 실습
 * @author 최홍준
 * @since 2024-10-06
 */

public class BankAccount2 {
    public static int count = 100;
    public int accountNumber;
    public String customerName;
    public double accountBalance;

    {
        accountNumber = count++;
    }

    public BankAccount2(String customerName, double accountBalance) {
        this.customerName = customerName;
        this.accountBalance = accountBalance;
    }

    public BankAccount2(String customerName) {
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
        if(accountBalance >= amount)
            account.accountBalance += amount;
        else
            System.out.println("출금 잔액 부족");
    }

    public void showAccount() {
        System.out.println("-".repeat(20));
        System.out.println("고객이름 : " + customerName);
        System.out.println("계좌번호 : " + accountNumber);
        System.out.println("잔   액 : " + accountBalance);
        System.out.println("-".repeat(20));
    }
}
