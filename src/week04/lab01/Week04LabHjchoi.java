package week04.lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 04주차 실습
 * 다차원 배열
 *
 * @author 최홍준
 * @since 2024-09-27
 */

public class Week04LabHjchoi {
    public static void lab01() {
        String[] names = {"홍길동", "고길동", "김길동", "이길동"};
        int[][] scores = {
                {10, 20, 30, 0, 1},
                {20, 30, 40, 0, 1},
                {10, 25, 30, 0, 1},
                {30, 30, 40, 0, 1}
        };
        getTotalScores(scores);
        getRankings(scores);
        showInfo(names, scores);
    }

    public static void getTotalScores(int[][] scores) {
        for (int[] score : scores) {
            for (int i = 0; i < score.length - 2; i++) {
                score[score.length - 2] += score[i];
            }
        }
    }

    public static void getRankings(int[][] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[i][scores[i].length - 2] < scores[j][scores[j].length - 2])
                    scores[i][scores[i].length - 1]++;
                else if (scores[i][scores[i].length - 2] > scores[j][scores[j].length - 2])
                    scores[j][scores[j].length - 1]++;
                else continue;
            }
        }
    }

    public static void showInfo(String[] names, int[][] scores) {
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " >> ");
            for (int j = 0; j < scores[i].length - 2; j++)
                System.out.print(scores[i][j] + " ");
            System.out.println(": " + scores[i][scores[i].length - 2] + " : " + scores[i][scores[i].length - 1]);
        }
    }

    public static void lab02() {
        File file = new File("res/scores.txt");
        try {
            Scanner scan = new Scanner(file);
            final int ROW = scan.nextInt();
            String[] names = new String[ROW];
            int[][] scores = new int[ROW][];
            int row = 0;
            while (scan.hasNext()) {
                final int COL = scan.nextInt();
                scores[row] = new int[COL + 2];
                names[row] = scan.next();
                for (int i = 0; i < COL; i++) {
                    scores[row][i] = scan.nextInt();
                }
                row++;
            }

            getTotalScores(scores);

            Scanner scan1 = new Scanner(file);
            double[] avgList = new double[ROW];
            scan1.nextLine();
            for (int i = 0; i < ROW; i++) {
                int col = scan1.nextInt();
                double avg = (double) scores[i][scores[i].length - 2] / col;
                avgList[i] = avg;
                scan1.nextLine();
                scores[i][scores[i].length - 1] = 1;
            }

            for (int i = 0; i < scores.length - 1; i++) {
                for (int j = i + 1; j < scores.length; j++) {
                    if (avgList[i] < avgList[j])
                        scores[i][scores[i].length - 1]++;
                    else if (avgList[i] > avgList[j])
                        scores[j][scores[j].length - 1]++;
                    else continue;
                }
            }

            for (int i = 0; i < names.length; i++) {
                System.out.print(names[i] + " >> ");
                for (int j = 0; j < scores[i].length - 2; j++)
                    System.out.print(scores[i][j] + " ");
                System.out.println(": " + scores[i][scores[i].length - 2] + " : " + avgList[i] + " : " + scores[i][scores[i].length - 1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수가 없습니다.");
        }
    }

    public static void main(String[] args) {
        System.out.println("202411913 최홍준");
        lab01();
        lab02();
    }
}
