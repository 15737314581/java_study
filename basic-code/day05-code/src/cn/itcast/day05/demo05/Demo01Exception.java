package cn.itcast.day05.demo05;

import java.io.IOException;

public class Demo01Exception {
    public static void main(String[] args) /* throws IOException */ {
        try {
            readFile("aaa.jpg");
        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            System.out.println(e.toString());
            e.printStackTrace();

        } finally {
            System.out.println("��Դ�ͷ�~");
        }
//        readFile("aaa.jpg");
        System.out.println("��������~");

    }

    public static void readFile(String fileName) throws IOException {
        if (!fileName.endsWith(".txt")) {
            throw new IOException("�ļ���׺������.txt");
        }
        System.out.println("�ļ���׺����ȷ");
    }
}
