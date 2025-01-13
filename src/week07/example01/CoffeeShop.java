package week07.example01;

public class CoffeeShop {

    static interface Payment {
        void processPayment(double amount);
    }

    static class CashPayment implements Payment {
        @Override
        public void processPayment(double amount) {
            System.out.println(amount + "현금결제완료");
        }
    }

    static class CardPayment implements Payment {
        @Override
        public void processPayment(double amount) {
            System.out.println(amount + "카드결제완료");
        }
    }

    private Coffee americano = new Coffee("아메리카노", 2000);
    private Coffee latte = new Coffee("카페라떼", 3000);
    private Coffee mocha = new Coffee("카페모카", 4000);

    public void order(String name, double amount, Payment payment) {
        payment.processPayment(amount);
        switch (name) {
            case "아메리카노" -> americano.brew();  //ctrl+d 하면 복제됨
            case "카페라떼" -> latte.brew();
            case "카페모카" -> mocha.brew();
            default -> System.out.println("판매하는 제품이 아닙니다.");
        }
    }

    private static class Coffee {
        private String name;
        private int brewTime;  // 멤버구성

        public Coffee(String name, int brewTime) {
            this.brewTime = brewTime;
            this.name = name;
        }

        public void brew() {
            class CoffeeThread extends Thread {
                @Override
                public void run() {
                    try {
                        System.out.println(name + "제조 시작");
                        Thread.sleep(brewTime);
                        System.out.println(name + "제조 완료");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            CoffeeThread coffeeThread = new CoffeeThread();
            coffeeThread.start();
        }
    }
}
