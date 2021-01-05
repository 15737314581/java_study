package cn.itcast.day05.demo07;

public class BaoziPu extends Thread{
    private Baozi bz;

    public BaoziPu(Baozi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (bz) {
                if(bz.status == true) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if(count % 2 == 0) {
                    bz.pi = "薄皮";
                    bz.xian = "猪肉大葱";
                } else {
                    bz.pi = "厚皮";
                    bz.xian = "韭菜鸡蛋";
                }
                count++;
                System.out.println("包子铺正在做"+bz.pi+bz.xian+"包子");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(bz.pi+bz.xian+"已经做好了，吃货可以吃了");
                bz.status = true;
                bz.notify();
            }


        }
    }
}
