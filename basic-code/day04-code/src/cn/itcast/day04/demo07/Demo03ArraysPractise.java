package cn.itcast.day04.demo07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Demo03ArraysPractise {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("ÇëÊäÈë×Ö·û´®£º");
        String str = input.next();
        System.out.println("Ô­Ê¼×Ö·û´®£º" + str);
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String str1 = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            str1 += chars[i];
        }
        System.out.println("µ¹ÐðºóµÄ×Ö·û´®£º" + str1);
    }
}
