package week05.example01;

import java.util.Scanner;

public class BankManager {
    private String branchName;
    private final int SIZE;
    private BankAccount2[] bankAccount2s;
    private int count = 0;

    public static Scanner scan = new Scanner(System.in);

    public BankManager(String branchName, int SIZE) {
        this.branchName = branchName;
        this.SIZE = SIZE;
        if (this.SIZE > 0) {
            bankAccount2s = new BankAccount2[this.SIZE];
        }
    }

    public void createAccount() {
        System.out.println("---------- 계좌 계설 ----------");
        if (this.count < this.SIZE) {
            System.out.print("이름 : ");
            String name = scan.next();
            System.out.print("입금할 금액 : ");
            double amount = scan.nextDouble();
            bankAccount2s[count++] = BankAccount2.getInstance(name, amount);
            System.out.println("계좌 개설 완료");
        } else {
            System.out.println("계좌 개설 불가");
        }
    }

    public void deposit() {
        System.out.println("---------- 입금 ----------");
        System.out.print("계좌번호 : ");
        int acc = scan.nextInt();
        BankAccount2 target = findAccount(acc);
        if (target != null) {
            System.out.print("입금금액 : ");
            int amount = scan.nextInt();
            target.deposit(amount);
        } else {
            System.out.println("계좌 번호 확인요망");
        }
    }

    public void withdraw() {
        System.out.println("---------- 출금 ----------");
        System.out.print("계좌번호 : ");
        int acc = scan.nextInt();
        BankAccount2 target = findAccount(acc);
        if (target != null) {
            System.out.print("출금금액 : ");
            int amount = scan.nextInt();
            target.withdraw(amount);
        } else {
            System.out.println("계좌 번호 확인요망");
        }
    }

    public void transfer() {
        System.out.println("---------- 계좌 이체 ----------");
        System.out.print("송금하는 계좌번호 : ");
        int acc1 = scan.nextInt();
        System.out.print("송금받는 계좌번호 : ");
        int acc2 = scan.nextInt();
        BankAccount2 target1 = findAccount(acc1);
        BankAccount2 target2 = findAccount(acc2);
        if (target1 != null && target2 != null) {
            System.out.print("이체할 금액 : ");
            int amount = scan.nextInt();
            if (target1.getAccountBalance() >= amount) {
                target1.withdraw(amount);
                target2.deposit(amount);
                System.out.println("계좌 이체 완료");
            } else {
                System.out.println("잔액 확인요망");
            }
        } else {
            System.out.println("계좌 번호 확인요망");
        }
    }

    public BankAccount2 findAccount(int target) {
        System.out.println("---------- 계좌 검색 ----------");
        if (this.count > 0) {
            for (int i = 0; i < this.count; i++) {
                if (bankAccount2s[i].getAccountNumber() == target) {
                    return bankAccount2s[i];
                }
            }
            return null;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        String str = "지점명 : " + this.branchName + "\n";
        str += "계좌 수 : " + this.count + "\n";
        str += "--------------------\n";
        for (BankAccount2 acc : this.bankAccount2s) {
            if (acc != null) {
                str += acc.toString() + "\n";
            }
        }
        str += "--------------------\n";
        return str;
    }
}
