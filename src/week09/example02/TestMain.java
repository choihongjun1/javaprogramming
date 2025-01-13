package week09.example02;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * 예외처리
 */

public class TestMain {
    public static void example01() {
//        throw new Exception("일반예외");
//        throw new RuntimeException("실행예외");
        int num = 100;
        Random random = new Random();
        while (true) {
            try {
                int result = num / random.nextInt(100);
                System.out.println(result);
                if (result > 10)
                    return;
            } catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없음");
            } finally {
                System.out.println("다음 연산 수행");
            }
        }
    }

    private static void example02(String[] args) throws ClassNotFoundException {
        try {
            Class tmp = Class.forName("week09.TestMain2");
            String data1 = args[0];
            String data2 = args[1];
            int value1 = Integer.parseInt(data1);
            int value2 = Integer.parseInt(data2);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 객체 확인 요망");
        } catch (NumberFormatException e) {
            System.out.println("숫자 형식 확인 요망");
        }
    }

    public static void main(String[] args) {
//        example01();
//
//        try {
//            example02(args);
//        } catch (ClassNotFoundException e) {
//            System.out.println("클래스 이름 확인 요망");
//        }
//
//        example03();

        printObject(new TestMain());
        printObject(new String("greenjoa"));
    }

    private static void example03() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("1)빵 2)커피 3)종료 ==> ");
                int choice = scanner.nextInt();
                if (!(choice >= 1 && choice <= 3)) {
                    //  System.out.println("메뉴를 확인하세요.");
                    throw new MenuRangeCheckException("메뉴를 확인하세요."); // 예외를 만들어줌
                }
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력하세요.");
                scanner.nextLine();
            } catch (MenuRangeCheckException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void printObject(Object obj) {
        System.out.println(obj.hashCode());
        System.out.println(obj.getClass().getName());  //클래스 이름 정보
        System.out.println(obj.getClass().getPackageName());
        System.out.println(obj.toString());
        System.out.println(obj);
    }
}


