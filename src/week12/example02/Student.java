package week12.example02;

public class Student implements Comparable<Student> {
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

    @Override
    public int compareTo(Student s) {
        return this.sid.compareTo(s.sid);
    }
}
