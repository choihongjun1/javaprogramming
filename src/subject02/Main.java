package subject02;

/**
 * 과제2
 * 메인 클래스
 *
 * @author 최홍준
 * @since 2024-12-13
 * 요구사항 1~3 Yes
 */

public class Main {
    /**
     * main 함수
     *
     * @param args 단어장파일
     */
    public static void main(String[] args) {
        VocManager manager = new VocManager("최홍준");
        manager.run(args[0]);
        MainFrame mf = new MainFrame("최홍준");
    }
}
