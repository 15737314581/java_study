package cn.itcast.day04.demo03;

public class Demo01MethodSame {
    public static void main(String[] args) {
        System.out.println(isSame(2,2));
    }

    public static boolean isSame(int a, int b) {
//        boolean same;
//        if(a == b){
//            same = true;
//        }else {
//            same = false;
//        }
//        return same;

//        boolean same = a==b ? true:false;
//        return same;

        return a == b;
    }
}
