package cn.itcast.day05.demo08;

import java.io.File;
import java.io.FileFilter;

public class Demo01Filter {
    public static void main(String[] args) {
        File file = new File("/Users/jijianfeng/Desktop/±¨Ïúµ¥");
        getAllfilter(file);
    }

    private static void getAllfilter(File file) {
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".txt");
            }
        });
        for (File f : files) {
            System.out.println(f);
        }

    }
}
