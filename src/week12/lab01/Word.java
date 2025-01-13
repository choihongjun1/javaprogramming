package week12.lab01;

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
        return eng.equals(word.eng);
//        return Objects.equals(eng, word.eng) && Objects.equals(kor, word.kor);
    }

    @Override
    public int hashCode() {
//        return Objects.hashCode(eng);
        return eng.hashCode();
    }

    @Override
    public String toString() {
        return eng + " : " + kor;
    }
}
