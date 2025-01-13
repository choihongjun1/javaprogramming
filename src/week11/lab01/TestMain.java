package week11.lab01;

import java.util.List;
import java.util.Vector;

/**
 * 컬렉션과 제너릭, List 컬렉션
 */

public class TestMain {
    public static void main(String[] args) {
//        MyArrayGeneric<Integer> arr1 = new MyArrayGeneric<>(5);
//        MyArrayGeneric<String> arr2 = new MyArrayGeneric<>(5);
//        MyArrayGeneric<Word> arr3 = new MyArrayGeneric<>(5);
//        arr3.add(new Word("red1", "빨강색1"));
//        arr3.add(new Word("red2", "빨강색2"));
//        arr3.add(new Word("red3", "빨강색3"));
//        System.out.println(arr3);
//
//        Integer[] arr1 = {10, 20, 30, 40};
//        String[] arr2 = {"홍길동", "김길동"};
//        printArray(arr1);
//        printArray(arr2);

        lab02();
    }

    public static <T> void printArray(T[] arr) {
        for (T t : arr) {
            System.out.println(t);
        }
    }

    private static void lab02() {
//        List<Integer> list1 = new Vector<>();
//        Vector<String> list2 = new Vector<>();
//        Vector<String> list3 = new Vector<>(3);
//        System.out.println(list2.size() + " : " + list2.capacity());
//        System.out.println(list3.size() + " : " + list3.capacity());
//        list3.add("greenjoa1");
//        list3.add("greenjoa2");
//        list3.add("greenjoa3");
//        list3.add("greenjoa4");
//        System.out.println(list3.size() + " : " + list3.capacity());
//        Vector<String> list4 = new Vector<>(3, 5);
//        list4.add("greenjoa1");
//        list4.add("greenjoa2");
//        list4.add("greenjoa2");
//        list4.add("greenjoa2");
//        list4.add("greenjoa2");
//        list4.add("greenjoa3");
//        list4.add("greenjoa4");
//        System.out.println(list4.size() + " : " + list4.capacity());
//        Vector<String> list5 = new Vector<>(list4);
//        System.out.println(list5);
//        list5.remove(1);
//        list5.remove("greemjoa3");
//        while (list5.contains("greenjoa2")) {
//            int idx = list5.indexOf("greenjoa2");
//            list5.remove(idx);
//        }
//        System.out.println(list5);
        Vector<Word> list = new Vector<>();
        list.add(new Word("red1", "빨강색1"));
        list.add(new Word("red2", "빨강색2"));
        list.add(new Word("red3", "빨강색3"));
        list.add(new Word("red4", "빨강색4"));
        list.add(new Word("red2", "빨강색2"));
        list.add(new Word("red2", "빨강색2"));
        System.out.println(list);
        while (list.contains(new Word("red2", "빨강색2"))) {
            int idx = list.indexOf(new Word("red2", "빨강색2"));
            list.remove(idx);
        }
        System.out.println(list);
    }
}
