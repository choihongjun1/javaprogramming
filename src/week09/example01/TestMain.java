package week09.example01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 예외처리, Object 클래스
 */

public class TestMain {
    public static void print(Object obj) {
        System.out.println(obj.getClass().getName());
        System.out.println(obj.hashCode());
        System.out.println(obj.toString());
        System.out.println(obj);
    }

    public static void main(String[] args) {
//        fileMerge("files/words1.txt", "files/words2.txt", "files/words.txt");
        fileMerge2("files/words1.txt", "files/words2.txt", "files/words7.txt");
    }

    private static void fileMerge2(String filename1, String filename2, String filename3) {
        try (
                Scanner file1 = new Scanner(new File(filename1));
                Scanner file2 = new Scanner(new File(filename2));
                PrintWriter outfile = new PrintWriter(new File(filename3));
        ) {
            writeFile(file1, outfile);
            writeFile(file2, outfile);
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        }
    }

    private static void fileMerge(String filename1, String filename2, String filename3) {
        Scanner file1 = null;
        Scanner file2 = null;
        PrintWriter outfile = null;
        try {
            file1 = new Scanner(new File(filename1));
            file2 = new Scanner(new File(filename2));
            outfile = new PrintWriter(new File(filename3));
            writeFile(file1, outfile);
            writeFile(file2, outfile);
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } finally {
            if (file1 != null) file1.close();
            if (file2 != null) file2.close();
            if (outfile != null) outfile.close();
        }
    }

    private static void writeFile(Scanner file, PrintWriter outfile) {
        while (file.hasNextLine()) {
            String str = file.nextLine();
            outfile.println(str);
//            outfile.println(file.nextLine());
        }
    }
}
