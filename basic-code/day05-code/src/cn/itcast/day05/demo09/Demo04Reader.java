package cn.itcast.day05.demo09;

import java.io.FileReader;
import java.io.IOException;

public class Demo04Reader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("/Users/jijianfeng/Desktop/workspace/basic-code/day05-code/src/cn/itcast/day05/a.txt");
        int len = 0;
        char[] btes = new char[1024];
        while ((len = fr.read(btes)) != -1){
            System.out.println(new String(btes,0,len));
        }
        fr.close();
    }
}
