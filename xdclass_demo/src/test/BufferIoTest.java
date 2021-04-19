package test;

import java.io.*;

public class BufferIoTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/data/aaa/a.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/src/data/aaa/copy_a.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] buf = new byte[1024];
        int length;
        while ((length = bis.read(buf)) != -1){
            bos.write(buf,0,length);
        }
        bis.close();
        bos.close();
    }

}
