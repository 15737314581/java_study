package cn.itcast.day05.demo03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo06CollectionsSort {
    public static void main(String[] args) {
        ArrayList<Person> list01 = new ArrayList<>();
        Collections.addAll(list01,new Person("�Ʊ�",20), new Person("ղķ˹",22),
                new Person("b����ɭ", 18), new Person("a����",18));
        System.out.println(list01);

//        Collections.sort(list01, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });
        Collections.sort(list01, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.getAge() - o2.getAge();
                if (result == 0) {
                    result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return result;
            }
        });
        System.out.println(list01);
    }

}
