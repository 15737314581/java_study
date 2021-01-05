package cn.itcast.day05.demo07;

public class Chihuo extends Thread{
    private Baozi bz;

    public Chihuo(Baozi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bz) {
                if (bz.status == false) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("吃货正在吃"+bz.pi+bz.xian+"包子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(bz.pi+bz.xian+"包子被吃货吃完了");
                bz.status = false;
                bz.notify();
                System.out.println("-------------------------");
            }

        }
    }
}
