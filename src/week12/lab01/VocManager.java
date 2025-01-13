package week12.lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class VocManager {
    String name;
    HashMap<String, Word> voc = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public VocManager(String name) {
        this.name = name;
    }

    public void addWord(Word w) {
        voc.put(w.eng, w);
    }

    public void run(String filename) {
        try {
            Scanner scan = new Scanner(new File(filename), "UTF-8");
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
                System.out.print("1)단어검색 2)종료 3)부분검색>> "); //이따가 나만의 메뉴를 3번에 만듦.
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
        Word word = voc.get(eng);
        if (word != null)
            System.out.println(word);
        else
            System.out.println("단어장에 등록되지 않은 단어입니다.");
    }

    public void searchWord2() {
        System.out.println("------부분 검색 -------");
        System.out.print("검색할 영단어를 입력하세요 : ");

        String eng = scanner.nextLine();
        int count = 0;
        Set<String> set = voc.keySet();
        for (var key : set) {
            if (key.indexOf(eng) == 0) {
                System.out.println(voc.get(key));
                count++;
            }
        }
    }
}