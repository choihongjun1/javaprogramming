package week05.lab01;

/**
 * 05주차 실습
 * @author 최홍준
 * @since 2024-10-06
 */

public class Week05LabHjchoi {
   public static void lab01() {
       BankAccount acc1 = new BankAccount(100, "홍길동", 1000);
       acc1.deposit(100);
       acc1.withdraw(200);
       acc1.withdraw(2000);
       acc1.showAccount();

       BankAccount acc2 = new BankAccount(101, "이길동");
       acc1.transfer(acc2, 1000);
       acc1.transfer(acc2, 500);
       acc2.showAccount();
   }

   public static void lab02() {
        BankAccount2 acc1 = new BankAccount2("홍길동", 1000);
        acc1.deposit(100);
        acc1.withdraw(200);
        acc1.withdraw(2000);
        acc1.showAccount();

        BankAccount2 acc2 = new BankAccount2("이길동");
        acc1.transfer(acc2, 1000);
        acc1.transfer(acc2, 500);
        acc2.showAccount();
   }

    public static void main(String[] args) {
        System.out.println("202411913 최홍준");
        lab01();
        lab02();
    }
}
