package cn.itcast.day05.demo09;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo02InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("/Users/jijianfeng/Desktop/workspace/basic-code/day05-code/src/cn/itcast/day05/a.txt"));
//        int len = 0;
//        while ((len = fis.read()) != -1){
//            System.out.println((char)len);
//        }
//        fis.close();

        byte[] btes = new byte[1024];
        int len = 0;
        while ((len = fis.read(btes)) != -1){
            System.out.println(new String(btes,0,len));
        }
    }

}
