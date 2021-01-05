package cn.itcast.day05.demo04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo01Map {
    public static void main(String[] args) {
        method01();
    }

    private static void method01() {
        Map<String, Integer> map = new HashMap<>();
        map.put("С��", 20);
        map.put("С��", 10);
        map.put("С��", 30);
        map.put("С��", 40);

//        System.out.println(map);
//        Integer a = map.get("С��");
//        System.out.println(a);
//        Integer b = map.remove("С��");
//        System.out.println(b);
//        boolean c = map.containsKey("С��");
//        System.out.println(c);
        Set<String> set = map.keySet();
        for (String key : set) {
            Integer value = map.get(key);
            System.out.println(key + "=" + value);
        }
    }
}
