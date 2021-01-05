package cn.itcast.day05.demo06;

public class RunnableImpl3 implements Runnable {
    private int tickes = 20;


    @Override
    public void run() {
        while (true) {
          payTickes();
        }
    }

    public synchronized void payTickes(){
            if (tickes > 0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ "-->正在卖第"+ tickes +"张票");
                tickes--;

            }
        }
}
