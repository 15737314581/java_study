package cn.itcast.day05.demo02;

public class Demo01StringBuilder {
    public static void main(String[] args) {
        StringBuilder bu1 = new StringBuilder();
        StringBuilder bu2 = bu1.append("abc").append(123).append(false).append("¹þ¹þ");
        System.out.println("bu1:" + bu1 + ",  bu2:" + bu2);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
        long  end= System.currentTimeMillis();
        System.out.println("¹²ºÄÊ±:" + (end - start)+ "ºÁÃë");
    }
}
