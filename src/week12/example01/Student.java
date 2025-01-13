package week12.example01;

public class Student {
    String sid;
    String sname;
    int kor;
    int math;

    public Student(String sid, String sname, int kor, int math) {
        this.sid = sid;
        this.sname = sname;
        this.kor = kor;
        this.math = math;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", kor=" + kor +
                ", math=" + math +
                '}';
    }
}
