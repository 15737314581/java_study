package cn.itcast.day04.demo03;

public class Demo02MethodSum {
    public static void main(String[] args) {
        sum(1,100);
    }

    public static void sum(int a, int b) {
        int sumber = 0;
        for (int i = a; i <=b; i++) {
            sumber += i;
        }
        System.out.println("从" + a + "到" + b +"相加的和为：" + sumber);
    }
}
