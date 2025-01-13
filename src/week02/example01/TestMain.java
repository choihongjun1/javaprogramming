package week02.example01;

import java.io.IOException;
import java.util.Scanner;

/**
기본 입출력, 연산자
 */

public class TestMain {
    public static void example01() throws IOException {
        int code;
        while ((code = System.in.read()) != -1) {
            System.out.println("code = " + code + ", char = " + (char) code);
        }
        code = System.in.read();
        System.out.println("code =" + code);
        code = System.in.read();
        System.out.println("code =" + code);
    }

    public static void example02() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("학번: ");
        String stdId = scanner.next();
        System.out.print("성 : ");
        String stdName1 = scanner.next();
        scanner.nextLine();
        System.out.print("이름 : ");
        String stdName2 = scanner.nextLine();
        System.out.println("이름은 " + stdName1 + "," + stdName2 + "이고, 학번은 " + stdId + "입니다.");
    }

    public static void example03() {
        int rgb = 0x00_ff_88_ff;
        int mask = 0xff_ff_00_ff;
        int result = rgb & mask;
        String rgbStr = Integer.toBinaryString(rgb);
        rgbStr = String.format("%32s", rgbStr).replace(' ', '0');
        System.out.println(rgbStr);
        String resultStr = Integer.toBinaryString(result);
        resultStr = String.format("%32s", resultStr);
        System.out.println(resultStr);
    }

    public static void main(String[] args) throws IOException {
        example02();
    }
}