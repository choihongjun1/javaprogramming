package subject01;

/**
 * 과제1
 * 요구사항 1~10 Yes
 *
 * @author 최홍준
 * @since 2024-10-10
 */

public class Main {
    /**
     * 메인 함수
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("202411913 최홍준");
        ParkingLot konkuk = new ParkingLot("res/konkuk.txt");
        konkuk.menu();
    }
}
