package cn.itcast.day05.demo03;

public class MyImp1 implements InterfaceMyCeneric<String> {
    @Override
    public void method(String s) {
        System.out.println(s);
    }
}
