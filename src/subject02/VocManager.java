package subject02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 과제2
 * 단어장 클래스
 *
 * @author 최홍준
 * @since 2024-12-13
 */

public class VocManager {
    String name; // 사용자 이름
    ArrayList<Word> voc = new ArrayList<>(); // 단어장 리스트
    static Scanner scanner = new Scanner(System.in);
    Random r = new Random();
    int n = 10; // 주관식 문제수
    int n2 = 10; // 객관식 문제수
    int nn = 4; // 객관식 보기수

    // 생성자
    public VocManager(String name) {
        this.name = name;
    }

    /**
     * 단어추가
     *
     * @param w 단어
     */
    public void addWord(Word w) {
        if (!voc.add(w))
            System.out.println("더이상 단어를 추가할 수 없습니다.");
    }

    /**
     * 단어장 생성
     *
     * @param filename 단어장 파일
     */
    public void run(String filename) {
        try {
            Scanner scan = new Scanner(new File(filename));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] w = line.split("\t"); // 탭 기준 분리
                this.addWord(new Word(w[0].trim(), w[1].trim())); // 공백제거 후 추가
            }
            System.out.println(name + "의 단어장이 생성되었습니다.");
            menu();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수가 없습니다.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("잘못된 파일형식입니다.");
        }
    }

    /**
     * 메뉴
     */
    public void menu() {
        int choice = 0;
        while (choice != 5) {
            try {
                System.out.println();
                System.out.println("------ " + name + "의 영단어 퀴즈 ------");
                System.out.println("1) 주관식 퀴즈 2) 객관식 퀴즈 3) 오답노트 4) 단어검색 5) 종료");
                System.out.print("메뉴를 선택하세요 : ");
                choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                switch (choice) {
                    case 1 -> quiz1();
                    case 2 -> quiz2();
                    case 3 -> wrongAnswer();
                    case 4 -> searchWord();
                    case 5 -> System.out.println(name + "의 단어장 프로그램을 종료합니다.");
                    default -> System.out.println("1~5 중 선택하세요."); // 범위 벗어남
                }
            } catch (InputMismatchException e) { // 정수가 아니면
                System.out.println();
                System.out.println("정수를 입력하세요.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) { // 빈 파일이면
                System.out.println("빈 단어장입니다.");
            }
        }
    }

    /**
     * 주관식 문제 리스트
     *
     * @return 문제리스트
     */
    private List<Word> getQList() {
        List<Word> qList = new ArrayList<>();
        while (qList.size() != n) {
            int num = r.nextInt(voc.size());
            Word word = voc.get(num); // 단어장에서 랜덤으로 가져오기
            if (!qList.contains(word)) { // 문제 리스트에 없으면
                qList.add(word); // 문제리스트에 추가
                Iterator<Word> iterator = qList.iterator();
                while (iterator.hasNext()) {
                    Word w = iterator.next();
                    if ((w != word) && (w.kor.equals(word.kor))) { // 자신을 제외하고 한글 뜻이 같은 단어가 이미 있으면
                        iterator.remove(); // 한글 뜻 중복 단어 삭제
                    }
                }
            }
        }
        return qList;
    }

    /**
     * 주관식 문제별 정답리스트
     *
     * @param w 정답 단어
     * @return 정답리스트
     */
    private List<Word> getOList(Word w) {
        List<Word> oList = new ArrayList<>();
        for (Word word : voc) {
            if (word.kor.equals(w.kor)) { // 한글 뜻 같으면
                oList.add(word); // 정답리스트에 추가
                word.appearCount++; // 단어 출현횟수 증가
            }
        }
        return oList;
    }

    /**
     * 주관식 퀴즈
     */
    public void quiz1() {
        int o = 0; // 정답 수

        List<Word> qList = getQList(); // 문제 리스트

        long startTime = System.nanoTime(); // 시작시간
        for (int i = 0; i < n; i++) {
            Word w = qList.get(i); // 정답객체
            List<Word> oList = getOList(w); // 정답리스트

            System.out.println("------ 주관식 퀴즈 " + (i + 1) + "번 ------");
            System.out.println("\"" + w.kor + "\"의 뜻을 가진 영어 단어는 무엇일까요?");
            System.out.print("답을 입력하세요 : ");
            String answer = scanner.nextLine();

            if (oList.contains(new Word(answer, ""))) { // 정답리스트에 답과 일치하는 객체 있으면
                System.out.println("정답입니다.");
                o++; // 정답수 증가
            } else { // 오답이면
                if (oList.size() == 1) {
                    System.out.println("틀렸습니다. 정답은 " + w.eng + "입니다.");
                    w.wrongCount++; // 단어 오답횟수 증가
                } else { // 중복 한글뜻이 있으면
                    System.out.print("틀렸습니다. 정답은 ");
                    for (int j = 0; j < oList.size(); j++) {
                        Word ww = oList.get(j);
                        if (j != oList.size() - 1) {
                            System.out.print(ww.eng + " 또는 ");
                        } else {
                            System.out.print(ww.eng);
                        }
                        ww.wrongCount++; // 단어 오답횟수 증가
                    }
                    System.out.println("입니다.");
                }
            }
        }
        long endTime = System.nanoTime(); // 끝 시간
        long t = (endTime - startTime) / 1000000000; // 걸린시간
        System.out.println();
        System.out.println(name + "님 " + n + "문제 중 " + o + "개 맞추셨고, 총 " + t + "초 소요되었습니다.");
    }

    /**
     * 객관식 문제 리스트
     *
     * @return 문제리스트
     */
    private List<Word> getQList2() {
        List<Word> qList = new ArrayList<>(); // 문제 리스트
        while (qList.size() != n2) {
            int num = r.nextInt(voc.size());
            Word word = voc.get(num); // 단어장에서 랜덤으로 가져오기
            if (!qList.contains(word)) { // 문제리스트에 없으면
                qList.add(word); // 문제리스트에 추가
            }
        }
        return qList;
    }

    /**
     * 객관식 문제별 보기 리스트
     *
     * @param w 정답 단어
     * @return 보기리스트
     */
    private List<Word> getOptionList(Word w) {
        List<Word> optionList = new ArrayList<>(); // 보기 리스트
        optionList.add(w); // 정답객체 추가
        while (optionList.size() != nn) {
            int num = r.nextInt(voc.size());
            Word word = voc.get(num); // 단어장에서 랜덤으로 가져오기
            if (!optionList.contains(word)) { // 보기리스트에 없으면
                boolean b = false;
                optionList.add(word); // 보기리스트에 추가
                for (Word ww : optionList) {
                    if ((ww != word) && (ww.kor.equals(word.kor))) { // 자신을 제외하고 한글 뜻 같은 단어 있으면
                        b = true;
                        break;
                    }
                }
                if (b) {
                    optionList.remove(word); // 보기리스트에서 삭제
                }
            }
        }
        return optionList;
    }

    /**
     * 객관식 퀴즈
     */
    public void quiz2() {
        int o = 0; // 정답 수

        List<Word> qList = getQList2(); // 문제 리스트

        long startTime = System.nanoTime(); // 시작 시간
        for (int i = 0; i < n2; i++) {
            Word w = qList.get(i); // 정답 객체
            List<Word> optionList = getOptionList(w); // 보기 리스트

            Collections.shuffle(optionList); // 섞기
            int oNum = optionList.indexOf(w) + 1; // 정답번호

            System.out.println("------ 객관식 퀴즈 " + (i + 1) + "번 ------");
            System.out.println(w.eng + "의 뜻은 무엇일까요?");

            // 보기 출력
            for (int j = 0; j < nn; j++) {
                System.out.println((j + 1) + ") " + optionList.get(j).kor);
            }

            System.out.print("답을 입력하세요 : ");
            String str = scanner.nextLine();
            try {
                int answer = Integer.parseInt(str); // 답을 정수로 변환
                if (answer == oNum) { // 정답인 경우
                    System.out.println("정답입니다.");
                    o++;
                } else { // 오답이거나 범위를 벗어난 경우
                    System.out.println("틀렸습니다. 정답은 " + oNum + "번 입니다.");
                    w.wrongCount++; // 오답횟수 증가
                }
            } catch (NumberFormatException e) { // 정수가 아닌 경우
                System.out.println("틀렸습니다. 정답은 " + oNum + "번 입니다.");
                w.wrongCount++; // 오답횟수 증가
            }
            w.appearCount++; // 출제횟수 증가
        }
        long endTime = System.nanoTime(); // 끝 시간
        long t = (endTime - startTime) / 1000000000; // 걸린 시간
        System.out.println();
        System.out.println(name + "님 " + n2 + "문제 중 " + o + "개 맞추셨고, 총 " + t + "초 소요되었습니다.");
    }

    /**
     * 오답노트
     */
    public void wrongAnswer() {
        long count = voc.stream().filter(o -> o.wrongCount > 0).count(); // 오답수 1이상 단어 개수

        if (count == 0) { // 틀린 단어 없으면
            System.out.println("틀린 문제가 없습니다.");
        } else { // 틀린 단어 있으면
            voc.stream().filter(o -> o.wrongCount > 0) // 오답수 1이상
                    .sorted((o1, o2) -> o2.wrongCount - o1.wrongCount) // 오답수 내림차순 정렬
                    .forEach(System.out::println); // 오답단어 정보 출력
        }
    }

    /**
     * 단어검색
     */
    public void searchWord() {
        System.out.println("------ 단어 검색 ------");
        System.out.print("검색할 단어를 입력하세요 : ");
        String eng = scanner.nextLine();
        int index = voc.indexOf(new Word(eng, "")); // 입력한 단어 저장된 인덱스
        if (index != -1) // 입력 단어가 단어장에 있으면
            System.out.println(voc.get(index));
        else // 입력 단어가 단어장에 없으면
            System.out.println("단어장에 등록되지 않은 단어입니다.");
    }
}