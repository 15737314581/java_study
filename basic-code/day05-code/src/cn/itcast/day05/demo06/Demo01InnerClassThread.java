package cn.itcast.day05.demo06;

public class Demo01InnerClassThread {
    public static void main(String[] args) {
        //匿名内部类/接口实现线程的创建
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "-->" + i);
                }
            }
        }.start();

        Runnable run = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println(Thread.currentThread().getName() + "-->" + i);
                }
            }
        };
        new Thread(run).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println(Thread.currentThread().getName() + "-->" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
