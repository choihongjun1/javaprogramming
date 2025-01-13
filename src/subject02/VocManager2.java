package subject02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 과제2
 * 프레임용 단어장 클래스
 *
 * @author 최홍준
 * @since 2024-12-13
 */

public class VocManager2 {
    String name; // 사용자 이름
    ArrayList<Word> voc = new ArrayList<>(); // 단어장
    Random r = new Random();
    int n = 10; // 주관식 문제수
    int n2 = 10; // 객관식 문제수
    int nn = 4; // 객관식 보기수

    // 생성자
    public VocManager2(String name) {
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
     * @return 생성결과
     */
    public String run(String filename) {
        try {
            Scanner scan = new Scanner(new File(filename));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] w = line.split("\t"); // 탭 기준 분리
                this.addWord(new Word(w[0].trim(), w[1].trim())); // 공백제거 후 추가
            }
            return name + "의 단어장이 생성되었습니다.";
        } catch (FileNotFoundException e) {
            return "파일을 찾을 수가 없습니다.";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "잘못된 파일형식입니다.";
        }
    }

    /**
     * 주관식 문제 리스트
     *
     * @return 문제리스트
     */
    public List<Word> getQList() {
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
                        iterator.remove();
                    }
                }
            }
        }
        return qList;
    }

    /**
     * 주관식 문제별 정답리스트
     *
     * @param w 정답단어
     * @return 정답리스트
     */
    public List<Word> getOList(Word w) {
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
     * 객관식 문제 리스트
     *
     * @return 문제리스트
     */
    public List<Word> getQList2() {
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
     * 객관식 문제별 보기 르스트
     *
     * @param w 정답 단어
     * @return 보기리스트
     */
    public List<Word> getOptionList(Word w) {
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
     * 오답노트
     *
     * @return 오답노트 내용
     */
    public String wrongAnswer() {
        long count = voc.stream().filter(o -> o.wrongCount > 0).count(); // 오답수 1이상 단어수

        StringBuffer str = new StringBuffer();

        if (count == 0) { // 틀린 단어 없으면
            str.append("틀린 문제가 없습니다.");
        } else { // 틀린 단어 있으면
            voc.stream().filter(o -> o.wrongCount > 0) // 오답수 1이상 단어
                    .sorted((o1, o2) -> o2.wrongCount - o1.wrongCount) // 오답수 내림차순 정렬
                    .forEach(o -> str.append(o + "\n")); // 오답단어 정보
        }
        return str.toString(); // 문자열로 변환 후 리턴
    }

    /**
     * 단어검색
     *
     * @param eng 검색 단어
     * @return 단어 정보
     */
    public String searchWord(String eng) {
        int index = voc.indexOf(new Word(eng, "")); // 검색된 단어 인덱스
        if (index != -1) // 단어장에 없으면
            return voc.get(index).toString(); // 단어정보
        else // 단어장에 있으면
            return "단어장에 등록되지 않은 단어입니다.";
    }
}