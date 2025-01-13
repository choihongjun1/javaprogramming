package week06.lab01;

/**
 * 06주차 실습
 * 다형성, 인터페이스, 추상클래스
 *
 * @author 최홍준
 * @since 2024-10-11
 */

public class Week06LabHjchoi {
    public static void lab01() {
        Home home = new Home(7);
        home.buyHA(new TV("건국TV", 5));
        home.buyHA(new Refrigerator("건국냉장고", -1));
        home.buyHA(new Vacuum("건국청소기", 2));
        home.buyHA(new Boiler("건국보일러", 20));
        home.buyHA(new TV("대학TV", 10));
        home.open();
    }

    public static void lab02() {
        Home home = new Home(7);
        home.buyHA(new TV("건국TV", 15));
        home.buyHA(new Refrigerator("건국냉장고", 0));
        home.buyHA(new Vacuum("건국청소기", 1));
        home.buyHA(new Boiler("건국보일러", 21));
        home.buyHA(new TV("대학TV", 10));

        IoTInterface iot = home.connect();
        if (iot != null) {
            iot.turnOn();
            iot.control();
            iot.turnOff();
        } else {
            System.out.println("connect 실패!!");
        }
    }

    public static void main(String[] args) {
        System.out.println("202411913 최홍준");
        lab01();
        lab02();
    }
}
