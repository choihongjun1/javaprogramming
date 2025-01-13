package week11.lab02;

import java.util.*;

/**
 * List 컬렉션, Set 컬렉션
 */

public class TestMain {
    public static void main(String[] args) {
//        VocManager manager = new VocManager("홍길동");
//        manager.run(args[0]);
//        lab01();
//        ArrayList<ArrayList<String>> list = new ArrayList<>();
//        list.add(new ArrayList<>());
//        list.add(new ArrayList<>());
//        list.add(new ArrayList<>());
//        list.get(0).add("greenjoa1");
//        list.get(0).add("greenjoa2");
//        list.get(1).add("greenjoa1");
//        list.get(1).add("greenjoa2");
//        list.get(1).add("greenjoa3");
//        System.out.println(list);
//        System.out.println(list.get(1).get(1));
//        ArrayList<String> list = new ArrayList<>();
//        list.add("홍길동");
//        list.add("이길동");
//        list.add("김길동");
//        Iterator<String> it = list.iterator();
//        while (it.hasNext()) {
//            String str = it.next();
//            if (str.equals("김길동"))
//                it.remove();
//        }
//        System.out.println(list);
//        ListIterator<String> it = list.listIterator();
//
//        while (it.hasNext()) {
//            String str = it.next();
//            System.out.println(str);
//        }
//        System.out.println("-----------------------");
//        while (it.hasPrevious()) {
//            System.out.println(it.previous());
//        }
        HashSet<Word> set1 = new HashSet<>();
        set1.add(new Word("red", "빨강"));
        set1.add(new Word("blue", "파랑"));
        set1.add(new Word("green", "초록"));
        set1.add(new Word("green", "초록"));
        System.out.println(set1);

        HashSet<Word> set2 = new HashSet<>();
        set2.add(new Word("yellow", "노랑"));
        set2.add(new Word("blue", "파랑"));
        set2.add(new Word("green", "초록"));
        set2.add(new Word("orange", "주황"));

        set2.retainAll(set1);
        System.out.println(set2);
    }

    private static void lab01() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < 10_0000; i++) {
            list1.add(0, i);
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 10_0000; i++) {
            list2.add(0, i);
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
