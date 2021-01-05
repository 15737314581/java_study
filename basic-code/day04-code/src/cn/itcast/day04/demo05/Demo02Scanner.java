package cn.itcast.day04.demo05;


import java.util.Scanner;

public class Demo02Scanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        System.out.println("年龄为：" + age);
        String name = sc.next();
        System.out.println("姓名为：" + name);
    }
}
