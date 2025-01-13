package subject02;

/**
 * 과제2
 * 단어 클래스
 *
 * @author 최홍준
 * @since 2024-12-13
 */

public class Word {
    String eng;
    String kor;
    int appearCount = 0; // 출제횟수
    int wrongCount = 0; // 오답횟수

    public Word(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }

    /**
     * equals 재정의
     *
     * @param o 비교 단어
     * @return 영어가 같으면 참
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return eng.equals(word.eng);
    }

    /**
     * toString 재정의
     *
     * @return 단어 정보
     */
    @Override
    public String toString() {
        return eng + " 뜻 : " + kor +
                "\n출제회수 : " + appearCount + "     오답회수 : " + wrongCount +
                "\n---------------------------------------------";
    }
}
