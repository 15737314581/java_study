package cn.itcast.day04.demo06;

import java.util.Random;
import java.util.Scanner;
//��������Ϸ

public class Demo01RandomGame {
    public static void main(String[] args) {
        Random r = new Random();
        int randomNum = r.nextInt(100) + 1;
        int max = 100;
        int min = 1;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            if (i < 5) {
                System.out.println("������²�����֣�");
                int guessNum = sc.nextInt();
                if (guessNum > randomNum) {
                    max = guessNum;
                    System.out.println("̫���ˣ������ԣ����ַ�Χ��" + min + "~" + max);
                } else if (guessNum < randomNum) {
                    min = guessNum;
                    System.out.println("̫С�ˣ������ԣ����ַ�Χ��" + min + "~" + max);
                } else {
                    System.out.println("��ϲ�㣬�¶���");
                    break;
                }
            }
            else {
                System.out.println("���������ꡫ");
            }
        }
        System.out.println("��Ϸ������");
    }
}
