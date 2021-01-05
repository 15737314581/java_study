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
            System.out.println("资源释放~");
        }
//        readFile("aaa.jpg");
        System.out.println("后续代码~");

    }

    public static void readFile(String fileName) throws IOException {
        if (!fileName.endsWith(".txt")) {
            throw new IOException("文件后缀名不是.txt");
        }
        System.out.println("文件后缀名正确");
    }
}
