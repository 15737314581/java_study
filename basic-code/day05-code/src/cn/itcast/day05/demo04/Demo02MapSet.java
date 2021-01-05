package cn.itcast.day05.demo04;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Demo02MapSet {
    public static void main(String[] args) {
        methoh01();
    }

    private static void methoh01() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ÇëÊäÈëÒ»¸ö×Ö·û´®£º");
        String s = sc.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char key : s.toCharArray()) {
            if (map.containsKey(key)) {
                Integer value = map.get(key);
                value++;
                map.put(key,value);
            } else {
                map.put(key, 1);
            }
        }
        System.out.println(map);
        Set<Character> set = map.keySet();
        for (Character key : set) {
            Integer value = map.get(key);
            System.out.println(key + "=" + value);
        }
    }
}
