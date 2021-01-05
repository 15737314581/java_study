package cn.itcast.day05.demo08;

public class DiGuidemo {
    public static void main(String[] args) {
        int s = getValue(5);
        System.out.println(s);
    }

    public static int getValue(int n) {
        if (n == 1) {
            return 1;
        }
        return n * getValue(n - 1);
    }
}
