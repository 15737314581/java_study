package cn.itcast.day05.demo13;

import java.util.function.Function;

public class Demo06Test03 {
    public static void main(String[] args) {
        String str = "ÕÔÀöÓ±,22";
        int num = change(str, (String s) -> {
            return str.split(",")[1];
        }, (String s) -> {
            return Integer.parseInt(s);
        }, (Integer i) -> {
            return i + 10;
        });
        System.out.println(num);
    }

    public static int change(String str, Function<String,String> fun1, Function<String,Integer> fun2, Function<Integer,Integer> fun3){
        return fun1.andThen(fun2).andThen(fun3).apply(str);
    }
}
