package cn.itcast.day05.demo09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo07InputStreamReader {


    public static void main(String[] args) throws IOException {
        read_utf_8();
        read_gbk();
    }


    private static void read_utf_8() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("/Users/jijianfeng/Desktop/workspace/basic-code/day05-code/src/cn/itcast/day05/utf-8.txt"),"utf-8");
        int len = 0;
        while ((len = isr.read()) != -1){
            System.out.println((char) len);
        }
        isr.close();
    }

    private static void read_gbk() throws IOException{
        InputStreamReader isr = new InputStreamReader(new FileInputStream("/Users/jijianfeng/Desktop/workspace/basic-code/day05-code/src/cn/itcast/day05/gbk.txt"),"GBK");
        int len = 0;
        while ((len = isr.read()) != -1){
            System.out.println((char) len);
        }
        isr.close();
    }
}
