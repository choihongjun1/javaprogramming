package week10.lab01;

import java.util.Scanner;

public class Player {
    String name;
    String word;

    public Player(String name) {
        this.name = name;
    }

    public String getWordFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(name + ">> ");
        this.word = scanner.next();
        return word;
    }

    public boolean checkSuccess(String lastWord, int strLen) {
        int lastIndex = lastWord.length() - strLen;
        if (lastWord.charAt(lastIndex) == word.charAt(0))
            return true;
        else
            return false;
    }

    public boolean checkSuccess2(String lastWord, int strLen, int comnum) {
        int lastIndex = lastWord.length() - strLen;
        if (lastWord.substring(lastIndex, lastIndex + comnum).equals(word.substring(0, comnum)))
            return true;
        else
            return false;
    }
}