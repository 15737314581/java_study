package test;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException {

//
//        String canonicalPath = file.getCanonicalPath();
//        System.out.println(canonicalPath);

        String filepath1 = System.getProperty("user.dir") + File.separator + "src/data/aaa/a.txt";
        String filepath2 = System.getProperty("user.dir") + "/src/data/aaa/b.txt";
        File file1 = new File(filepath1);
        File file2 = new File(filepath2);
//        file.createNewFile();

//        file.mkdirs();
        InputStream fis = new FileInputStream(file1);
//        ioTest1(fis);
        OutputStream fos = new FileOutputStream(file2);
        ioTest2(fis,fos);


    }

    public static void ioTest2(InputStream fis, OutputStream fos) throws IOException {
        byte[] buf = new byte[1024];
        int length;
        while ((length = fis.read(buf)) != -1) {
            fos.write(buf,0,length);
        }
        fos.close();
        fis.close();
    }

    public static void ioTest1(InputStream fis) throws IOException {

        byte[] buf = new byte[1024];
        int length;
        while ((length = fis.read(buf)) != -1) {
            System.out.println(new String(buf, 0, length, "UTF-8"));

        }
        fis.close();
    }
}
