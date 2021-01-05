package cn.itcast.day05.demo06;

public class Demo05Thread {
    public static void main(String[] args) {
        RunnableImpl4 run = new RunnableImpl4();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        t1.start();
        t2.start();
        t3.start();
    }
}
