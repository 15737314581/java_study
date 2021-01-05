package cn.itcast.day05.demo04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Demo03Doudizhu {
    public static void main(String[] args) {
        //准备牌
        HashMap<Integer,String> puker = new HashMap<>();
        ArrayList<Integer> indexlist = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();
        Collections.addAll(colors,"梅花", "黑桃", "方片", "红桃");
        Collections.addAll(numbers,"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        Integer index = 0;
        puker.put(index, "大王");
        indexlist.add(index);
        index++;
        puker.put(index, "小王");
        indexlist.add(index);
        index++;
        for (String number : numbers) {
            for (String color : colors) {
                puker.put(index, color+number);
                indexlist.add(index);
                index++;
            }
        }
//        System.out.println(puker);
//        System.out.println(indexlist);

        //洗牌
        Collections.shuffle(indexlist);
//        System.out.println(indexlist);

        //发牌
        ArrayList<Integer> player01 = new ArrayList<>();
        ArrayList<Integer> player02 = new ArrayList<>();
        ArrayList<Integer> player03 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();

        for (int i = 0; i < indexlist.size() ; i++) {
            if (i >= 51) {
                dipai.add(indexlist.get(i));
            } else if (i % 3 == 0) {
                player01.add(indexlist.get(i));
            }else if (i % 3 == 1) {
                player02.add(indexlist.get(i));
            }else {
                player03.add(indexlist.get(i));
            }
        }

        //排序
        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);
        Collections.sort(dipai);

        //看牌
        showPai("小王", puker, player01);
        showPai("小张", puker, player02);
        showPai("小李", puker, player03);
        showPai("底牌", puker, dipai);
    }

    public static void showPai(String playername, HashMap<Integer,String> puker, ArrayList<Integer> playerlist) {
        System.out.print(playername + ": ");
        for (Integer key : playerlist) {
            String value = puker.get(key);
            System.out.print(value + " ");
        }
        System.out.println();
    }

}
