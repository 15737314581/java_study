package cn.itcast.day05.demo09;

import java.io.*;
import java.util.HashMap;

public class Demo05Test {
    public static void main(String[] args) throws IOException {
        HashMap<String,String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("/Users/jijianfeng/Desktop/workspace/basic-code/day05-code/src/cn/itcast/day05/in.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/jijianfeng/Desktop/workspace/basic-code/day05-code/src/cn/itcast/day05/out.txt"));

        String line;
        while ((line = br.readLine()) != null){
            String[] sp = line.split("\\.");
            map.put(sp[0],sp[1]);
        }

        for (String key : map.keySet()) {
            String value = map.get(key);
            line = key + "." + value;
            bw.write(line);
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
