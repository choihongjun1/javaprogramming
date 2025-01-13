package week13.example01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 람다식, 함수형 인터페이스, Stream
 */

public class TestMain {
    public static void main(String[] args) {
        var list = new ArrayList<Student>();
        list.add(new Student("2000", "홍길동", 60, 90));
        list.add(new Student("2010", "김길동", 65, 50));
        list.add(new Student("2020", "이길동", 80, 40));
        list.add(new Student("2030", "박길동", 85, 30));
        list.add(new Student("2040", "고길동", 90, 80));

//        Predicate<Student> predicate = new Predicate<Student>() {
//            @Override
//            public boolean test(Student student) {
//                return student.kor >= 80;
//            }
//        };
        Predicate<Student> predicate = student -> student.kor >= 80;
        for (var std : list) {
            if (predicate.test(std))
                System.out.println(std);
        }

        list.stream().sorted(((o1, o2) -> o1.kor - o2.kor)).filter(student -> student.kor >= 80).limit(1).forEach(System.out::println);
        var resultList = list.stream().filter(student -> student.kor >= 80).toList();

        var korAvg = list.stream().collect(Collectors.averagingInt(Student::getKor));
        var mathSum = list.stream().collect(Collectors.summingInt(Student::getMath));
    }
}