package cn.itcast.day04.demo06;

import java.util.ArrayList;

public class Demo04ArraylistPrint {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("�Ʊ�");
        list.add("�����");
        list.add("ղķ˹");
        list.add("Τ��");
        System.out.println(list);
        printArraylist(list);

    }

    public static void printArraylist(ArrayList<String> list) {
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if (i == list.size() - 1) {
                System.out.print(name + "}");
            } else {
                System.out.print(name + "@");
            }
        }
    }
}
