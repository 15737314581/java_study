package cn.itcast.day04.demo06;

import java.util.Random;
import java.util.Scanner;
//猜数字游戏

public class Demo01RandomGame {
    public static void main(String[] args) {
        Random r = new Random();
        int randomNum = r.nextInt(100) + 1;
        int max = 100;
        int min = 1;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            if (i < 5) {
                System.out.println("请输入猜测的数字：");
                int guessNum = sc.nextInt();
                if (guessNum > randomNum) {
                    max = guessNum;
                    System.out.println("太大了，请重试！数字范围：" + min + "~" + max);
                } else if (guessNum < randomNum) {
                    min = guessNum;
                    System.out.println("太小了，请重试！数字范围：" + min + "~" + max);
                } else {
                    System.out.println("恭喜你，猜对了");
                    break;
                }
            }
            else {
                System.out.println("机会已用完～");
            }
        }
        System.out.println("游戏结束！");
    }
}
