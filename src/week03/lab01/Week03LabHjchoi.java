package week03.lab01;

import java.util.Random;
import java.util.Scanner;

/**
 * 03주차 실습
 * 배열, 조건문, 반복문
 *
 * @author 최홍준
 * @since 2024-09-20
 */

public class Week03LabHjchoi {
    public static void lab01() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("무슨 커피 드릴까요? ");
        String order = scanner.next();
        if (order.equals("Americano") || order.equals("Espresso")) {
            System.out.println(order + "는 2500원입니다.");
        } else if (order.equals("Cappuccino") || order.equals("CafeLatte")) {
            System.out.println(order + "는 3500원입니다.");
        } else {
            System.out.println("판매하는 제품이 아닙니다.");
        }
    }

    public static void lab02() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("무슨 커피 드릴까요? ");
        String order = scanner.next();
        switch (order) {
            case "Americano":
            case "Espresso":
                System.out.println(order + "는 2500원입니다.");
                break;
            case "Cappuccino":
            case "CafeLatte":
                System.out.println(order + "는 3500원입니다.");
                break;
            default:
                System.out.println("판매하는 제품이 아닙니다.");
        }
    }

    public static void lab03() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("무슨 커피 드릴까요? ");
        String order = scanner.next();
        switch (order) {
            case "Americano", "Espresso" -> System.out.println(order + "는 2500원입니다.");
            case "Cappuccino", "CafeLatte" -> System.out.println(order + "는 3500원입니다.");
            default -> System.out.println("판매하는 제품이 아닙니다.");
        }
    }

    public static void lab04() {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        System.out.println("가위(0), 바위(1), 보(2)중에 하나를 입력해주세요.");
        System.out.print("입력 : ");
        int user = scanner.nextInt();
        int com = r.nextInt(3);
        String winner;
        switch (user) {
            case 0 -> System.out.println("user : 가위");
            case 1 -> System.out.println("user : 바위");
            case 2 -> System.out.println("user : 보");
        }
        switch (com) {
            case 0 -> System.out.println(" com : 가위");
            case 1 -> System.out.println(" com : 바위");
            case 2 -> System.out.println(" com : 보");
        }

        if (user == com) {
            System.out.println("무승부");
        } else {
            if ((user - 1) * (com - 1) == 0) {
                winner = (user > com) ? "사용자" : "컴퓨터";
                System.out.println(winner + "가 이겼습니다.");
            } else {
                winner = (user < com) ? "사용자" : "컴퓨터";
                System.out.println(winner + "가 이겼습니다.");
            }
        }
    }

    public static void lab05() {
        int n = 10;
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= 2;
            System.out.print(result);
            if (i < n) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void lab06() {
        Scanner scanner = new Scanner(System.in);
        int count = 0, n = 0;
        double sum = 0;

        System.out.println("정수를 입력하고 마지막에 0을 입력하세요.");
        while ((n = scanner.nextInt()) != 0) {
            sum = sum + n;
            count++;
        }
        if (count == 0) {
            System.out.println("입력된 값이 없습니다.");
        } else {
            System.out.print("수의 개수는 " + count + "개이며 ");
            System.out.println("평균은 " + sum / count + "입니다.");
        }
    }

    public static void lab07() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("정수를 5개 입력하세요.");
        int sum = 0;
        int i = 0;

        while (i < 5) {
            int n = scanner.nextInt();
            if (n <= 0) continue;
            else sum += n;
            i++;
        }
        System.out.println("양수의 합은 " + sum);
    }

    public static void lab08() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.print("아이디와 비밀번호를 입력하세요 : ");
            String id = scanner.next();
            String password = scanner.next();
            if (id.equals("greenjoa") && password.equals("java")) {
                System.out.println(id + "님 환영합니다.");
                break;
            }
            if (i < 3) {
                System.out.println("아이디 또는 비밀번호가 다릅니다.");
                System.out.println(i + "번째 시도중입니다.");
            } else {
                System.out.println("틀린 정보를 3번 입력하여 프로그램을 종료합니다.");
            }
        }
    }

    public static void lab09() {
        int[] lotto = new int[6];
        Random r = new Random();
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = r.nextInt(45) + 1;
            for (int j = 0; j < i; j++) {
                if (lotto[j] == lotto[i]) {
                    i--;
                    break;
                }
            }
        }
        for (int i = 0; i < lotto.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < lotto.length; j++) {
                if (lotto[j] < lotto[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = lotto[minIndex];
                lotto[minIndex] = lotto[i];
                lotto[i] = temp;
            }
        }
        System.out.print("로또 번호 : ");
        for (int i : lotto) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("202411913 최홍준");
        lab01();
        lab02();
        lab03();
        lab04();
        lab05();
        lab06();
        lab07();
        lab08();
        lab09();
    }
}
