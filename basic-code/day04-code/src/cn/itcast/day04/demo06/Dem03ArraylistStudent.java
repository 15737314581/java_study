package cn.itcast.day04.demo06;
import cn.itcast.day04.demo05.Student;

import java.util.ArrayList;

public class Dem03ArraylistStudent {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student one = new Student("小张", 12);
        Student two = new Student("小王", 14);
        Student three = new Student("小李", 22);
        Student four = new Student("小赵", 32);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
//        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println("姓名：" + stu.getName() + ", 年龄： " + stu.getAge());
        }
    }
}
