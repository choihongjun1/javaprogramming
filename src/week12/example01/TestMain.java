package week12.example01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map 컬렉션
 */

public class TestMain {
    public static void main(String[] args) {
        HashMap<String, Student> map = new HashMap<>();
        map.put("2000", new Student("2000", "홍길동", 50, 60));
        map.put("2010", new Student("2010", "이길동", 90, 70));
        map.put("2020", new Student("2020", "김길동", 60, 90));
        map.put("2020", new Student("2020", "김길동", 80, 100));
        System.out.println(map.get("2020"));
        map.remove("2020");
        System.out.println(map);
//        Set<String> set = map.keySet();
////        for (String key : set) {
////            System.out.println(key + " : " + map.get(key));
////        }
//        Iterator<String> it = set.iterator();
//        while (it.hasNext()) {
//            String key = it.next();
//            System.out.println(key + " : " + map.get(key));
//        }
//
//        Set<Map.Entry<String, Student>> set = map.entrySet();
//        Iterator<Map.Entry<String, Student>> it = set.iterator();
//        while (it.hasNext()) {
//            Map.Entry<String, Student> entry = it.next();//반환받는 데이터를 지역변수로 생성
//            String key = entry.getKey();
//            Student value = entry.getValue();
//            System.out.println(key + " : " + value);
//        }
//
//        var set = map.entrySet();
//        var it = set.iterator();
//        while (it.hasNext()) {
//            var entry = it.next();
//            var key = entry.getKey();
//            var value = entry.getValue();
//            System.out.println(key + " : " + value);
//        }

//        Collection<Student> values = map.values();
        var values = map.values();
        var it2 = values.iterator();
        while (it2.hasNext()) {
            var std = it2.next();
            System.out.println(std);
        }
    }
}
