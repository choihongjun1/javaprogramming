package week07.example01;

/**
 * 중첩 클래스, 중첩 인터페이스
 */

public class TestMain {
    public static void main(String[] args) {
        CoffeeShop greenjoa = new CoffeeShop();
        greenjoa.order("아메리카노", 1000, new CoffeeShop.CashPayment());
        greenjoa.order("카페모카", 3000, new CoffeeShop.CashPayment());
        greenjoa.order("카페라떼", 2000, new CoffeeShop.CashPayment());
        greenjoa.order("아메리카노", 1000, new CoffeeShop.CardPayment());
    }
}
