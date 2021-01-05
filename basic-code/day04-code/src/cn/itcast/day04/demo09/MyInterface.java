package cn.itcast.day04.demo09;

public interface MyInterface {
    //抽象方法
    public abstract void methodAbstract();

    //默认方法
    public default void methodDefault() {
        System.out.println("这是一个默认方法");
//        methodPrivateDefault();
    }

    //静态方法
    public static void methodStatic() {
        System.out.println("这是一个静态方法");
//        methodPrivateStatic();
    }

//    //默认私有方法
//    private void methodPrivateDefault() {
//        System.out.println("默认私有方法AAAAA");
//    }
//
//    //静态私有方法
//    private static void methodPrivateStatic() {
//        System.out.println("静态私有方法BBB");
//    }
}
