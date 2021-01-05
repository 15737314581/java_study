package cn.itcast.day05.demo09;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("/Users/jijianfeng/Desktop/workspace/basic-code/day05-code/src/cn/itcast/day05/a.txt"), true);
        byte[] btes = {65,66,67,68,50};
        fos.write(btes);
        for (int i = 0; i < 5; i++) {
            byte[] byte1 = "ÄãºÃ".getBytes();
            fos.write(byte1);
            fos.write("\r\n".getBytes());
        }

        fos.close();
    }
}
