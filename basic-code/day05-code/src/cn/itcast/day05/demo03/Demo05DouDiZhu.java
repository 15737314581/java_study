package cn.itcast.day05.demo03;

import java.util.ArrayList;
import java.util.Collections;

public class Demo05DouDiZhu {
    public static void main(String[] args) {
        // 准备牌
        ArrayList<String> puke = new ArrayList<>();
        String[] colors = {"梅花", "黑桃", "方片", "红桃"};
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        puke.add("大王");
        puke.add("小王");
        for (String color : colors) {
            for (String number : numbers) {
                puke.add(color + number);
            }
        }

        //洗牌
        Collections.shuffle(puke);
        System.out.println(puke);

        //发牌
        ArrayList<String> player01 = new ArrayList<>();
        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();
        for (int i = 0; i < puke.size(); i++) {
            if (i >= 51) {
                diPai.add(puke.get(i));
            } else if (i % 3 == 0) {
                player01.add(puke.get(i));
            } else if (i % 3 == 1) {
                player02.add(puke.get(i));
            } else if (i % 3 == 2) {
                player03.add(puke.get(i));
            }

        }

        //看牌
        System.out.println("玩家A: " + player01);
        System.out.println("玩家B: " + player02);
        System.out.println("玩家C: " + player03);
        System.out.println("底牌: " + diPai);
    }
}
