package cn.itcast.day04.demo09;

public interface MyInterface {
    //���󷽷�
    public abstract void methodAbstract();

    //Ĭ�Ϸ���
    public default void methodDefault() {
        System.out.println("����һ��Ĭ�Ϸ���");
//        methodPrivateDefault();
    }

    //��̬����
    public static void methodStatic() {
        System.out.println("����һ����̬����");
//        methodPrivateStatic();
    }

//    //Ĭ��˽�з���
//    private void methodPrivateDefault() {
//        System.out.println("Ĭ��˽�з���AAAAA");
//    }
//
//    //��̬˽�з���
//    private static void methodPrivateStatic() {
//        System.out.println("��̬˽�з���BBB");
//    }
}
