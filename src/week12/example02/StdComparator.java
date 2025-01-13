package week12.example02;

import java.util.Comparator;

public class StdComparator implements Comparator<Student> {
    int flag;

    public StdComparator(int flag) {
        this.flag = flag;
    }

    @Override
    public int compare(Student o1, Student o2) {
        switch (flag) {
            case 0 -> {
                return o1.sname.compareTo(o2.sname);
            }
            case 1 -> {
                return (o1.kor - o2.kor) * -1;
            }
            case 2 -> {
                return (o1.math - o2.math) * -1;
            }
            default -> {
                return (o1.sid.compareTo(o2.sid)) * -1;
            }
        }
    }
}
