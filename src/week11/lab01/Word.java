package week11.lab01;

public class Word {
    String eng;
    String kor;

    public Word(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return eng.equals(word.eng) && kor.equals(word.kor);
        // return Objects.equals(eng, word.eng) && Objects.equals(kor, word.kor);
        // equals는 문자열을 사용할 때는 문제가 없는데 new로 생성한 것들은 이렇게 처리하면 안됨.
    }

    @Override
    public String toString() {
        return eng + " : " + kor;
    }
}
