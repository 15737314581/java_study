package test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WriterTest {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "/src/data/aaa/c.txt";
        writertest1(path);



    }

    public static void writertest1(String path) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        String str = "小滴课堂";
        // bw.newLine();
        bw.write(str);
        bw.close();

    }


}
