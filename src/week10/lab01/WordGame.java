package week10.lab01;

import java.util.Scanner;

public class WordGame {
    String startWord;
    int strLen;

    Player[] players;

    public WordGame(String startWord, int strLen) {
        this.startWord = startWord;
        this.strLen = strLen;
    }

    public void createPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("게임에 몇명이 참가하겠습니까 >> ");
        int numPlayer = scanner.nextInt();
        this.players = new Player[numPlayer];
        for (int i = 0; i < players.length; i++) {
            System.out.print("참가자의 이름을 입력하세요 >>");
            String name = scanner.next();
            players[i] = new Player(name);
        }
    }

    public void run() {
        System.out.println("끝말잇기 게임을 시작합니다.");
        createPlayer();
        System.out.println("시작단어는 " + startWord + "입니다.");
        int next = 0;
        while (true) {
            String newWord = players[next].getWordFromUser();
            if (!players[next].checkSuccess2(startWord, strLen, 2)) {
                System.out.println(players[next].name + "이 졌습니다.");
                break;
            }
            next++;
            next %= players.length;
            startWord = newWord;
        }
    }
}
