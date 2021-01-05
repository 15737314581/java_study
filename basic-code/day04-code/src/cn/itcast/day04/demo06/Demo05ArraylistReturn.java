package cn.itcast.day04.demo06;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Random;

public class Demo05ArraylistReturn {
    public static void main(String[] args) {
        ArrayList<Integer> bigList = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt(100) + 1;
            bigList.add(num);
        }
        System.out.println("初始集合：" + bigList);
        ArrayList<Integer> smalllist = getSmalllist(bigList);
        System.out.println("筛选后的集合：" + smalllist);
    }

    public static ArrayList<Integer> getSmalllist(ArrayList<Integer> list) {
        ArrayList<Integer> smalllist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int num1 = list.get(i);
            if (num1 % 2 == 0) {
                smalllist.add(num1);
            }
        }
        return smalllist;
    }

}
