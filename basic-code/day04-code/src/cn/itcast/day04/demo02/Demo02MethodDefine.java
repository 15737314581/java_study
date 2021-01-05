package cn.itcast.day04.demo02;

public class Demo02MethodDefine {
    public static void main(String[] args) {
        System.out.println(sum(12,13));
        System.out.println("==============");
        int sumber = sum(20,30);
        System.out.println("求和结果：" + sumber);
    }

    public static int sum(int a, int b) {
        int result = a + b;
        return result;
    }
}
