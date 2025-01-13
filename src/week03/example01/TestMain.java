package week03.example01;

import java.util.Random;
import java.util.Scanner;

/**
 * 조건문, 배열
 */

public class TestMain {
    public static void example01() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("알파벳 대소문자 또는 숫자 : ");
        String str = scanner.next();
        char a = str.charAt(0);

        if (a >= 'a' && a <= 'z') {
            System.out.println("문자 " + a + "는 소문자입니다.");
        } else if (a >= 'A' && a <= 'Z') {
            System.out.println("문자 " + a + "는 대문자입니다.");
        } else if (a >= '0' && a <= '9') {
            System.out.println("문자 " + a + "는 숫자입니다.");
        } else {
            System.out.println("문자 " + a + "는 알파벳 또는 숫자가 아닙니다.");
        }
    }

    public static void example02() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("월(1~12)을 입력하시오 : ");
        int month = scanner.nextInt();
        switch (month) {
            case 3, 4, 5 -> System.out.println("봄입니다.");
            case 6, 7, 8 -> System.out.println("여름입니다.");
            case 9, 10, 11 -> System.out.println("가을입니다.");
            case 12, 1, 2 -> System.out.println("겨울입니다.");
            default -> System.out.println("잘못된 입력입니다.");
        }
    }

    public static void example03() {
        int[] list = {10, 50, 60, 30, 20, 70};
//        int[] list = new int[]{10, 50, 60, 30, 20, 70};
//        가능
//        int[] list;
//        list = {10, 50, 60};
//        불가능
//        int[] list;
//        list = new int[]{10, 50, 60, 30, 20, 70};
//        가능
//        int[] list = new int[6];
//        list[0] = 10;
//        가능

        System.out.print("정렬 전 : ");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = list[minIndex];
                list[minIndex] = list[i];
                list[i] = temp;
            }
        }

        System.out.print("정렬 후 : ");
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    public static void example04() {
        String[] list = {"홍길동", "이길동", "고길동", "최길동", "김길동"};

        System.out.print("정렬 전 : ");
        for (String i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(list[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                String temp = list[minIndex];
                list[minIndex] = list[i];
                list[i] = temp;
            }
        }

        System.out.print("정렬 후 : ");
        for (String i : list) {
            System.out.print(i + " ");
        }
    }

    public static void example05() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4};

        boolean result = arrEquals(arr1, arr2);

        System.out.println(arr1 + "\t" + arr2);
        System.out.println(result ? "같음" : "같지않음");
    }

    public static boolean arrEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    public static void example06() {
        int[] lotto = makeLotto();
        for (int i : lotto) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] makeLotto() {
        int[] lotto = new int[6];
        Random rand = new Random();
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = rand.nextInt(45) + 1;
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
                    i--;
                    break;
                }
            }
        }
        return lotto;
    }

    public static void example07() {
        int[] answer = {1, 2, 1, 2, 3, 4, 4};
        int[] greenjoa = {1, 4, 3, 1, 2, 3, 4};

        System.out.print("정   답 : ");
        for (int i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("제출한답 : ");
        for (int i : greenjoa) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] quizResult = getQuizResult(answer, greenjoa.clone());

        System.out.print("평가결과 : ");
        for (int i : quizResult) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("제출한답 : ");
        for (int i : greenjoa) {
            System.out.print(i + " ");
        }
    }

    public static int[] getQuizResult(int[] answer, int[] std) {
        for (int i = 0; i < answer.length; i++) {
            if (std[i] == answer[i])
                std[i] = 1;
            else
                std[i] = 0;
        }
        return std;
    }

    public static void example08() {
        int[] greenjoa1 = {1, 4, 3, 1, 2, 3, 4};
        int[] greenjoa2 = {2, 2, 2, 2, 2, 2, 2};
        int[] std = new int[14];

        System.arraycopy(greenjoa1, 0, std, 0, greenjoa1.length);
        System.arraycopy(greenjoa2, 0, std, greenjoa1.length, greenjoa2.length);

        for (int i : std) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        example08();
    }
}