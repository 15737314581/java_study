package cn.itcast.day05.demo03;

import java.util.ArrayList;
import java.util.Collection;

public class Iterator {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("aaa");
        coll.add("ddd");
        coll.add("ccc");
        coll.add("eee");
        coll.add("fff");
        java.util.Iterator<String> it = coll.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("==================");
        for (String s : coll) {
            System.out.println(s);
        }
        System.out.println("==================");
        int[] list = {1,2,3,4,5};
        for (int i : list) {
            System.out.println(i);
        }
    }
}
