package cn.itcast.day04.demo11;

public class MethodMain {
    public static void main(String[] args) {
        MyInterface objA = new MyInterface() {
            @Override
            public void method() {
                System.out.println("�����ڲ��෵�ؽ��A");
            }
        };
        objA.method();

        new MyInterface() {
            @Override
            public void method() {
                System.out.println("�����ڲ��෵�ؽ��B");
            }
        }.method();

    }
}
