package cn.itcast.day05.demo03;

import java.util.ArrayList;
import java.util.Collection;

public class Demo01Collection {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("hh");
        coll.add("ww");
        boolean b1 = coll.add("mm");
        System.out.println(b1);
        System.out.println(coll);
        System.out.println(coll.size());
        System.out.println(coll.isEmpty());
        System.out.println(coll.contains("mm"));
        System.out.println(coll.contains("aa"));
        System.out.println(coll.remove("hh"));
        System.out.println(coll);
        coll.clear();
        System.out.println(coll.isEmpty());
        System.out.println(coll);
    }
}
