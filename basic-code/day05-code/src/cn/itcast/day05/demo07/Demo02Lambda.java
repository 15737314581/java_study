package cn.itcast.day05.demo07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Demo02Lambda {
    public static void main(String[] args) {
        Person[] arr = {
                new Person("小张",12),
                new Person("小李",18),
                new Person("小王",10),
        };

//        Arrays.sort(arr, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });

        Arrays.sort(arr, (Person o1, Person o2) -> {
            return o1.getAge() - o2.getAge();
        });

        for (Person p : arr) {
            System.out.println(p);
        }


    }
}
