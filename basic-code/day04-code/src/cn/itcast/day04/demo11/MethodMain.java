package cn.itcast.day04.demo11;

public class MethodMain {
    public static void main(String[] args) {
        MyInterface objA = new MyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类返回结果A");
            }
        };
        objA.method();

        new MyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类返回结果B");
            }
        }.method();

    }
}
