package cn.itcast.day04.demo09;

public class MethodMain {
    public static void main(String[] args) {
        MyInterfaceImpl1 myInterfaceImpl1 = new MyInterfaceImpl1();
        MyInterfaceImpl2 myInterfaceImpl2 = new MyInterfaceImpl2();
        myInterfaceImpl1.methodAbstract();
        myInterfaceImpl1.methodDefault();
        myInterfaceImpl2.methodAbstract();
        myInterfaceImpl2.methodDefault();
        MyInterface.methodStatic();
    }
}
