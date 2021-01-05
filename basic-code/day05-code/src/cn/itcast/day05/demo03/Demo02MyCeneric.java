package cn.itcast.day05.demo03;

public class Demo02MyCeneric {
    public static void main(String[] args) {
        MyCeneric<String> s1 = new MyCeneric<String>();
        s1.setI("ÄãºÃ");
        String s = s1.getI();
        System.out.println(s);

        MyCeneric<Integer> s2 = new MyCeneric<Integer>();
        s2.setI(11);
        Integer i = s2.getI();
        System.out.println(i);

        MyCeneric02 s3 = new MyCeneric02();
        s3.method01(111);
        s3.method01("¹þ¹þ¹þ");
        s3.method01(0.88);
        s3.method01(true);
        System.out.println("==============");
        MyCeneric02.method02(123);
        MyCeneric02.method02("kkk");
    }
}
