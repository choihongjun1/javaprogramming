package week15.example02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VocManager {
    String name;
    ArrayList<Word> voc = new ArrayList<>();

    public VocManager(String name) {
        this.name = name;
    }

    public void addWord(Word w) {
        if (!voc.add(w))
            System.out.println("더이상 단어를 추가할 수 없습니다.");
    }

    public String run(String filename) {
        try {
            Scanner scan = new Scanner(new File(filename));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] w = line.split("\t");
                this.addWord(new Word(w[0].trim(), w[1].trim()));
            }
            return name + "의 단어장이 생성되었습니다.";
        } catch (FileNotFoundException e) {
            return "파일을 찾을 수가 없습니다.";
        }
    }

    public Word searchWord(String eng) {
        int index = voc.indexOf(new Word(eng, ""));
        if (index != -1) {
            System.out.println(voc.get(index));
            return voc.get(index);
        } else {
            System.out.println("단어장에 등록되지 않은 단어입니다.");
            return null;
        }
    }

    public List<Word> searchWord2(String eng) {
        List<Word> list = new ArrayList<>();
        int count = 0;
        for (Word w : voc) {
            if (w != null) {
                if (w.eng.indexOf(eng) == 0) {
                    System.out.println(w);
                    list.add(w);
                    count++;
                }
            } else {
                break;
            }
        }
        if (count == 0) {
            System.out.println("단어장에 등록되지 않은 단어입니다.");
        }
        return list;
    }
}