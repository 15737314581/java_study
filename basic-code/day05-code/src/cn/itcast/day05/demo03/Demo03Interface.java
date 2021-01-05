package cn.itcast.day05.demo03;

public class Demo03Interface {
    public static void main(String[] args) {
        MyImp1 imp1 = new MyImp1();
        imp1.method("≤‚ ‘");
        MyImp2<Integer> imp2 = new MyImp2<>();
        imp2.method(123);
        MyImp2<Double> imp3 = new MyImp2<>();
        imp3.method(9.033);
    }
}
