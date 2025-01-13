package week09.lab01;

/**
 * Object 클래스
 */

public class TestMain {
    public static void main(String[] args) {
        Rect rect1 = new Rect(2,3);
        Rect rect2 = new Rect(3,2);
        Rect rect3 = new Rect(3,4);

        System.out.println(rect1.equals(rect2) ? "같다" : "다르다");
        System.out.println(rect2.equals(rect3) ? "같다" : "다르다");
    }
}
