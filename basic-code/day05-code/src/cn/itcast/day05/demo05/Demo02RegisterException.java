package cn.itcast.day05.demo05;

import java.util.Scanner;

public class Demo02RegisterException {
    static String[] usernames= {"小王", "小李"};
    public static void main(String[] args) throws RegisterException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入注册的用户名：");
        String username = sc.next();
        checkUsername(username);
//        System.out.println("后续代码~");
    }

    public static void checkUsername(String username) throws RegisterException {
        for (String s : usernames) {
            if (s.equals(username)) {
                throw new RegisterException("该用户已经注册过了~");
            }
        }
        System.out.println("注册成功~");
    }

}
