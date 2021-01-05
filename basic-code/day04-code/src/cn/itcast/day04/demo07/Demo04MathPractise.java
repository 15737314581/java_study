package cn.itcast.day04.demo07;

public class Demo04MathPractise {
    public static void main(String[] args) {
        double min = -10.8;
        double max = 5.9;
        int count = 0;
        for (double i = Math.ceil(min); i < max; i++) {
            System.out.println(i);
            double j = Math.abs(i);
            if (j > 6 || j < 2.1) {
                count++;
            }
        }
        System.out.println("×Ü¼Æ£º" + count);

    }
}
