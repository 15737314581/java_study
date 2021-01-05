package cn.itcast.day05.demo09;

import java.io.*;

public class Demo08Test02 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("/Users/jijianfeng/Desktop/workspace/basic-code/day05-code/src/cn/itcast/day05/gbk.txt"),"GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("/Users/jijianfeng/Desktop/workspace/basic-code/day05-code/src/cn/itcast/day05/utf-8-02.txt"),"UTF-8");
        int len = 0;
        while ((len = isr.read()) != -1) {
            osw.write(len);
        }
        osw.close();
        isr.close();
    }
}
