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
        map.put("小王", 20);
        map.put("小李", 10);
        map.put("小张", 30);
        map.put("小赵", 40);

//        System.out.println(map);
//        Integer a = map.get("小王");
//        System.out.println(a);
//        Integer b = map.remove("小张");
//        System.out.println(b);
//        boolean c = map.containsKey("小赵");
//        System.out.println(c);
        Set<String> set = map.keySet();
        for (String key : set) {
            Integer value = map.get(key);
            System.out.println(key + "=" + value);
        }
    }
}
