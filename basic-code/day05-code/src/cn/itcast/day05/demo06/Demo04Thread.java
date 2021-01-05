package cn.itcast.day05.demo06;

public class Demo04Thread {
    public static void main(String[] args) {
        RunnableImpl3 run = new RunnableImpl3();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        t1.start();
        t2.start();
        t3.start();
    }
}
