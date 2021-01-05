package cn.itcast.day05.demo03;

public class MyCeneric02 {
    public <E> void method01(E e) {
        System.out.println(e);
    }

    public static <M>  void method02(M m) {
        System.out.println(m);
    }
}
