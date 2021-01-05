package cn.itcast.day05.demo06;

public class RunnableImpl implements Runnable {
    private int tickes = 20;
    @Override
    public void run() {
        while (true) {
            if (tickes > 0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ "-->��������"+ tickes +"��Ʊ");
                tickes--;

            }
        }
    }
}
