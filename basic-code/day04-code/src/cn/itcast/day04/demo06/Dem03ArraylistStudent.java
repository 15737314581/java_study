package cn.itcast.day04.demo06;
import cn.itcast.day04.demo05.Student;

import java.util.ArrayList;

public class Dem03ArraylistStudent {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student one = new Student("С��", 12);
        Student two = new Student("С��", 14);
        Student three = new Student("С��", 22);
        Student four = new Student("С��", 32);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
//        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println("������" + stu.getName() + ", ���䣺 " + stu.getAge());
        }
    }
}
