package cn.itcast.day05.demo03;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo04 {
    public static void main(String[] args) {
        ArrayList<Integer> s1 = new ArrayList<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        ArrayList<String> s2 = new ArrayList<>();
        s2.add("a");
        s2.add("b");
        s2.add("c");
        getElement(s1);
        getElement(s2);
    }
    public static void getElement(ArrayList<?> list) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println(obj);
        }
    }
}
