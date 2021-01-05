package cn.itcast.day05.demo01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Demo01Test {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的出生日期，格式为yyyy-MM-dd");
        String birthdayDateString = sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = sdf.parse(birthdayDateString);
        long birthdayTime = birthdayDate.getTime();
        long todayTime = new Date().getTime();
        long leftTime = todayTime - birthdayTime;
        long leftDate = leftTime / 1000 / 60 / 60 / 24;
        System.out.println(leftDate);
    }
}
