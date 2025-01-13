package week11.lab02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class VocManager {
    String name;
    //    ArrayList<Word> voc = new ArrayList<>();
    LinkedList<Word> voc = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);

    public VocManager(String name) {
        this.name = name;
    }

    public void addWord(Word w) {
        if (!voc.add(w))
            System.out.println("더이상 단어를 추가할 수 없습니다.");
    }

    public void run(String filename) {
        try {
            Scanner scan = new Scanner(new File(filename));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] w = line.split("\t");
                this.addWord(new Word(w[0].trim(), w[1].trim()));
            }
            System.out.println(name + "의 단어장이 생성되었습니다.");
            menu();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수가 없습니다.");
        }
    }

    public void menu() {
        int choice = 0;
        while (choice != 2) {
            try {
                System.out.print("1)단어검색 2)종료 3)부분검색>> ");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> searchWord();
                    case 2 -> System.out.println("단어장 종료");
                    case 3 -> searchWord2();
                }
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력하세요.");
                scanner.nextLine();
            }
        }
    }

    public void searchWord() {
        System.out.println("------단어 검색 -------");
        System.out.print("검색할 영단어를 입력하세요 : ");
        String eng = scanner.nextLine();
        int index = voc.indexOf(new Word(eng, ""));
        if (index != -1)
            System.out.println(voc.get(index));
        else
            System.out.println("단어장에 등록되지 않은 단어입니다.");
    }

    public void searchWord2() {
        System.out.println("------부분 검색 -------");
        System.out.print("검색할 영단어를 입력하세요 : ");
        String eng = scanner.nextLine();
        int n = eng.length();
        int c = 0;
        for (Word w : voc) {
            if (w != null) {
                if (w.eng.substring(0, n).equals(eng)) {
                    System.out.println(w);
                }
                c++;
                if (c == voc.size()) {
                    break;
                }
            } else {
                System.out.println("단어장에 등록되지 않은 단어입니다.");
                break;
            }
        }
    }
}