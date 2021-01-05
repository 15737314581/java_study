package cn.itcast.day05.demo09;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Demo06OutputStreamWriter {
    public static void main(String[] args) throws IOException {
        write_utf_8();
        write_gbk();
    }


    private static void write_utf_8() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("/Users/jijianfeng/Desktop/workspace/basic-code/day05-code/src/cn/itcast/day05/utf-8.txt"),"utf-8");
        osw.write("ÄãºÃ");
        osw.flush();
        osw.close();
    }

    private static void write_gbk() throws IOException{
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("/Users/jijianfeng/Desktop/workspace/basic-code/day05-code/src/cn/itcast/day05/gbk.txt"),"GBK");
        osw.write("¸ñ¾Ö");
        osw.flush();
        osw.close();
    }
}
