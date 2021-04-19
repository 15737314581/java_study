package test;

import java.util.*;

public class InteratorTest {
    public static void main(String[] args) {
        // testSet();
        testList();
    }

    public static void testList(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(15);
        list.add(30);
        list.add(17);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            System.out.println(i);
        }
    }

    public  static void testSet(){
        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("ddd");
        set.add("bbb");
        set.add("eee");
        set.add("ccc");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }
    }
}
