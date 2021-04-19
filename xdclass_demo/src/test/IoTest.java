package test;

import java.io.*;

public class IoTest {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + "/src/data/aaa/image1");
        File[] files = file.listFiles();
        for (File f : files) {
            String filename = f.getName();
            copy(f.getAbsolutePath(), System.getProperty("user.dir")+"/src/data/aaa/image2"+File.separator+filename);

        }
    }

    public static void copy(String from, String to){
        try {
            File file = new File(new File(to).getParent());
            if (!file.exists()){
                file.mkdirs();
            }
            FileInputStream fis = new FileInputStream(from);
            BufferedInputStream bis = new BufferedInputStream(fis);
            FileOutputStream fos = new FileOutputStream(to);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            byte[] buf = new byte[1024];
            int length;
            while ((length = bis.read(buf)) != -1){
                bos.write(buf,0,length);
            }
            bis.close();
            bos.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
