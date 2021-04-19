package test;

import java.io.*;

public class IoTest2 {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "/src/data/aaa/c.txt";
        test1(path);
        //test2(path);

    }

    public static void test2(String path) {
        try (FileOutputStream fos = new FileOutputStream(path, true);
             OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
             BufferedWriter bw = new BufferedWriter(osw);
        ) {
            bw.write("测试一下");
            bw.newLine();
            bw.write("123456");
            bw.newLine();
            bw.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void test1(String path) {
        try (FileInputStream fis = new FileInputStream(path);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr);
        ) {
            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
