package cn.itcast.day05.demo06;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImpl4 implements Runnable {
    private int tickes = 20;
    Lock l = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            l.lock();
            if (tickes > 0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ "-->正在卖第"+ tickes +"张票");
                tickes--;
            }
            l.unlock();
        }
    }
}
