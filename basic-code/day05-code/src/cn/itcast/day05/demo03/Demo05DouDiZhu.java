package cn.itcast.day05.demo03;

import java.util.ArrayList;
import java.util.Collections;

public class Demo05DouDiZhu {
    public static void main(String[] args) {
        // ׼����
        ArrayList<String> puke = new ArrayList<>();
        String[] colors = {"÷��", "����", "��Ƭ", "����"};
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        puke.add("����");
        puke.add("С��");
        for (String color : colors) {
            for (String number : numbers) {
                puke.add(color + number);
            }
        }

        //ϴ��
        Collections.shuffle(puke);
        System.out.println(puke);

        //����
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

        //����
        System.out.println("���A: " + player01);
        System.out.println("���B: " + player02);
        System.out.println("���C: " + player03);
        System.out.println("����: " + diPai);
    }
}
