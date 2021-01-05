package cn.itcast.day05.demo03;

public class MyImp2<E> implements InterfaceMyCeneric<E>{
    @Override
    public void method(E e) {
        System.out.println(e);
    }
}
