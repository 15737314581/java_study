package cn.itcast.day04.demo06;

import java.util.ArrayList;
import java.util.Random;
//获取随机数集合
public class Demo02ArraylistRandom {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int randomNum = r.nextInt(100) + 1;
            list.add(randomNum);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list);
    }
}
