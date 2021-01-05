package cn.itcast.day05.demo13;

import sun.rmi.log.LogInputStream;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Demo05Test02 {
    public static void main(String[] args) {
        String[] arr = {"¹ÅÁ¦ÄÈÔú,Å®","Âí¶ûÔú¹ş,ÄĞ","ÕÔÀöÓ±,Å®","µÏÀöÈÈ°Í,Å®"};
        ArrayList<String> list = filter(arr, (str) -> {
            return str.split(",")[0].length() == 4;
        }, (str) -> {
            return str.split(",")[1].equals("Å®");
        });
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> filter(String[] arr, Predicate<String> pre1, Predicate<String> pre2){
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : arr) {
            boolean b = pre1.and(pre2).test(s);
            if(b){
                arrayList.add(s);
            }
        }
        return arrayList;
    }
}
