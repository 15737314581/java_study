package cn.itcast.day05.demo05;

import java.util.Scanner;

public class Demo02RegisterException {
    static String[] usernames= {"С��", "С��"};
    public static void main(String[] args) throws RegisterException {
        Scanner sc = new Scanner(System.in);
        System.out.println("������ע����û�����");
        String username = sc.next();
        checkUsername(username);
//        System.out.println("��������~");
    }

    public static void checkUsername(String username) throws RegisterException {
        for (String s : usernames) {
            if (s.equals(username)) {
                throw new RegisterException("���û��Ѿ�ע�����~");
            }
        }
        System.out.println("ע��ɹ�~");
    }

}
