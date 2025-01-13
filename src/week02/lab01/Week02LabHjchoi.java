package week02.lab01;

import java.util.Scanner;

/**
 * 02주차 실습
 * 타입, 타입변환, 기본 입출력
 *
 * @author 최홍준
 * @since 2024-09-13
 */

public class Week02LabHjchoi {
    public static void lab01() {
        final int COFFEE = 100;
        final int MILK = 50;
        final int WATER = 10;

        int coffeeNumber = 5;
        int milkNumber = 2;
        int waterNumber = 1;

        int coffeePrice = COFFEE * coffeeNumber;
        int milkPrice = MILK * milkNumber;
        int waterPrice = WATER * waterNumber;

        System.out.println("***** 주문 내역 *****");
        System.out.println("커피 : " + coffeeNumber + "잔 " + coffeePrice + "원");
        System.out.println("우유 : " + milkNumber + "잔 " + milkPrice + "원");
        System.out.println("물 : " + waterNumber + "잔 " + waterPrice + "원");
        System.out.println("********************");
        System.out.println("총 주문금액 : " + (coffeePrice + milkPrice + waterPrice) + "원");
    }

    public static void lab02() {
        byte b;
        int i = 414;
        float f = 123.456f;

        b = (byte) i;
        System.out.println("int 414를 byte로 변환 : " + b);
        i = (int) f;
        System.out.println("float 123.456을 int로 변환 : " + i);
        b = (byte) f;
        System.out.println("float 123.456을 byte로 변환 : " + b);
    }

    public static void lab03() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("학번 : ");
        String stdId = scanner.next();
        scanner.nextLine();
        System.out.print("이름 : ");
        String stdName = scanner.nextLine();
        System.out.print("나이 : ");
        int stdAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("주소 : ");
        String stdAddress = scanner.nextLine();

        System.out.println("학번 : " + stdId);
        System.out.println("이름 : " + stdName);
        System.out.println("나이 : " + stdAge);
        System.out.println("주소 : " + stdAddress);
    }

    public static void main(String[] args) {
        System.out.println("202411913 최홍준");
        lab01();
        lab02();
        lab03();
    }
}
