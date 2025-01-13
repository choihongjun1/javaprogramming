package week04.example01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 다차원 배열, 클래스
 */

public class TestMain {
    public static void example01() {
        String[] names = {"홍길동", "고길동", "김길동", "이길동"};
        int[][] scores = {
                {10, 20, 30, 0}, {20, 30, 40, 0}, {10, 25, 30, 0}, {30, 30, 40, 0}
        };
//        for (int i = 0; i < scores.length; i++)
//            getTotalScores(scores[i]);
        getTotalScores(scores);
        showInfo(names, scores);
    }

    private static void showInfo(String[] names, int[][] scores) {
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " >> ");
            for (int j = 0; j < scores[i].length - 1; j++)
                System.out.print(scores[i][j] + " ");
            System.out.println(" : " + scores[i][scores[i].length - 1]);
        }
    }

    private static void getTotalScores(int[][] scores) {
        for (int[] score : scores) {
            for (int i = 0; i < score.length - 1; i++) {
                score[score.length - 1] += score[i];
            }
        }
    }

    public static void example02() {
        File file = new File("res/scores.txt");
        try {
            Scanner scan = new Scanner(file);
            final int ROW = scan.nextInt();
            String[] names = new String[ROW];
            int[][] scores = new int[ROW][];
            int row = 0;

            while (scan.hasNext()) {
                final int COL = scan.nextInt();
                scores[row] = new int[COL + 1];
                names[row] = scan.next();
                for (int i = 0; i < COL; i++) {
                    scores[row][i] = scan.nextInt();
                }
                row++;
            }
            getTotalScores(scores);
            showInfo(names, scores);
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수가 없습니다.");
        }
    }

    public static void example03() {
        System.out.println("=== tv1 ===");
        TV tv1 = new TV();
        tv1.powerOnOff();
        tv1.channelUp();
        tv1.channelDown();
        for (int i = 0; i < 10; i++) {
            tv1.channelDown();
        }

        System.out.println("=== tv2 ===");
        TV tv2 = new TV();
        tv2.powerOnOff();
        tv2.channelUp();
        tv2.channelDown();
        System.out.println(tv1 + " : " + tv2);
        tv2 = tv1;
        tv2.showState();

        TV tv3 = new TV();
        tv3.powerOnOff();
        for (int i = 0; i < 25; i++) {
            tv3.volumeUp();
        }
        for (int i = 0; i < 25; i++) {
            tv3.volumeDown();
        }
    }

    public static void main(String[] args) {
        System.out.println("202411913 최홍준");
//        example01();
//        example02();
        example03();
    }
}