package week05.example01;

/**
 * 클래스, 생성자, 메소드, 객체배열
 */

public class TestMain {
    public static void example01() {
        System.out.println("=== tv1 ===");
        TV tv1 = new TV(false, 3);
        tv1.powerOnOff();
        tv1.channelUp();
        tv1.channelDown();

        System.out.println("=== tv2 ===");
        TV tv2 = new TV();
        tv2.powerOnOff();
        tv2.channelUp();
        tv2.channelDown();
        System.out.println(tv1 + " : " + tv2);
        tv2 = tv1;
        tv2.showTV();
    }

    public static void example02() {
        Vehicle car1 = new Vehicle("빨간색", 50, 200, '0', new TV(true, 8));
//        System.out.println("car1 : " + car1);
//        car1.showStatus();
//        car1.accelerate(20);
//        car1.showStatus();
//        car1.breaker(5);
//        car1.showStatus();
//        car1.changeGear('2');
//        car1.showStatus();

        System.out.println("----- car1 -----");
        car1.showStatus();

        Vehicle car2 = new Vehicle(car1);

        System.out.println("----- car2 -----");
        car2.tv.powerOnOff();
        car2.showStatus();
        System.out.println("----- car1 -----");
        car1.showStatus();
    }

    public static void example03() {
        System.out.println("========== 건국은행 ==========");
        BankManager bank1 = new BankManager("건국은행", 10);
        bank1.createAccount();
        bank1.createAccount();
        bank1.deposit();
        bank1.withdraw();
        bank1.transfer();

        System.out.println(bank1);

        System.out.println("========== 대학은행 ==========");
        BankManager bank2 = new BankManager("대학은행", 20);
    }

    public static void main(String[] args) {
        example03();
    }
}
