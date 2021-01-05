package cn.itcast.day04.demo12;

import java.util.Random;

public class MethonMain {
    public static void main(String[] args) {
        Person p1 = new Person("科比",25);
        Person p2 = new Person("科比",25);

        System.out.println(p1);
        System.out.println(p2);
//        p1 = p2;

        Random r = new Random();
        boolean b = p1.equals(p1);
        System.out.println(b);

    }
}
