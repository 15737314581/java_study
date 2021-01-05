package cn.itcast.day05.demo09;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo03CopyFile {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("/Users/jijianfeng/Downloads/Õº∆¨/timg.jpeg");
        FileOutputStream fos = new FileOutputStream("/Users/jijianfeng/Pictures/a.jpeg");
        int len = 0;
        byte[] btes = new byte[1024];
        while ((len = fis.read(btes)) != -1){
            fos.write(btes,0,len);
        }
        fos.close();
        fis.close();
        long e = System.currentTimeMillis();
        System.out.println("π≤∫ƒ ±£∫" + (e-s) +"∫¡√Î");
    }
}
