package week06.example02;

/**
 * 다형성, 인터페이스
 */

public class TestMain {
    public static void main(String[] args) {
//        TV tv = new TV("건국TV", 7);
//        tv.menu();
//        Refrigerator refrigerator = new Refrigerator("건국냉장고", -2);
//        refrigerator.menu();
//        Vacuum vacuum = new Vacuum("건국청소기", 2);
//        vacuum.menu();
//        Boiler boiler = new Boiler("건국보일러", 20);
//        boiler.menu();

        Home home = new Home(7);
        home.buyHA(new TV("건국TV", 5));
        home.buyHA(new Refrigerator("건국냉장고", -1));
        home.buyHA(new Vacuum("건국청소기", 2));
        home.buyHA(new Boiler("건국보일러", 20));
        home.buyHA(new TV("대학TV", 10));
//        home.open();
        home.scanIoTDevice();
    }
}
