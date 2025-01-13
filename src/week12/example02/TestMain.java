package week12.example02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Collections 클래스, 람다식
 */

public class TestMain {
    public static void main(String[] args) {
//        Integer[] arr = {5, 3, 7, 9, 10, 4, 1};
//        var list = Arrays.asList(arr);
////        var list2 = new ArrayList<Integer>();
////        list2.addAll(list);
////        Collections.addAll(list2, arr);
//        Collections.shuffle(list);
//        System.out.println(list);
////        Collections.sort(list);
////        System.out.println(list);
////        Collections.reverse(list);
////        System.out.println(list);
//        Collections.sort(list, Collections.reverseOrder());
//        System.out.println(list);
        var list = new ArrayList<Student>();
        list.add(new Student("2000", "홍길동", 60, 90));
        list.add(new Student("2010", "김길동", 65, 50));
        list.add(new Student("2020", "이길동", 80, 40));
        list.add(new Student("2030", "박길동", 85, 30));
        list.add(new Student("2040", "고길동", 90, 80));
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
//        Collections.sort(list, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
////                return o1.math - o2.math;
//                return (o1.math - o2.math) * -1;
//            }
//        });
        Collections.sort(list, ((o1, o2) -> (o1.math - o2.math) * -1));
        System.out.println(list);
        list.sort(new StdComparator(1));
        System.out.println(list);
        Collections.sort(list, new StdComparator(0));
        System.out.println(list);
        Collections.sort(list);
        int index = Collections.binarySearch(list, new Student("2030", "", 0, 0));
        if (index >= 0) {
            System.out.println(list.get(index));
        } else {
            System.out.println("찾는 객체 없음");
        }
//        Collections.sort(list, new StdComparator(0));
//        int index2 = Collections.binarySearch(list, new Student("", "김길동", 0, 0), new StdComparator(0));
//        if (index2 >= 0) {
//            System.out.println(list.get(index));
//        } else {
//            System.out.println("찾는 객체 없음");
//        }
        list.sort((o1, o2) -> o1.sname.compareTo(o2.sname));
        int index2 = Collections.binarySearch(list, new Student("", "김길동", 0, 0), (o1, o2) -> o1.sname.compareTo(o2.sname));
        if (index2 >= 0)
            System.out.println(list.get(index2));
        else
            System.out.println("찾는 객체 없음.");
    }
}
