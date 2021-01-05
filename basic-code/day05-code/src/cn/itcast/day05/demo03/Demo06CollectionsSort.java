package cn.itcast.day05.demo03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo06CollectionsSort {
    public static void main(String[] args) {
        ArrayList<Person> list01 = new ArrayList<>();
        Collections.addAll(list01,new Person("科比",20), new Person("詹姆斯",22),
                new Person("b艾佛森", 18), new Person("a卡特",18));
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
