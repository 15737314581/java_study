package cn.itcast.day04.demo07;

import java.util.Scanner;

public class Demo02StringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("������һ���ַ���");
        String str = sc.next();
        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0;
        int countOther = 0;
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if ('A' <= ch && ch <= 'Z') {
                countUpper++;
            } else if ('a' <= ch && ch <= 'z') {
                countLower++;
            } else if ('0' <= ch && ch <= '9') {
                countNumber++;
            } else {
                countOther++;
            }
        }
        System.out.println("��д��ĸ������" + countUpper);
        System.out.println("Сд��ĸ������" + countLower);
        System.out.println("���ָ�����" + countNumber);
        System.out.println("�����ַ���" + countOther);
    }
}
