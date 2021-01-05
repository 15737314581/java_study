package cn.itcast.day05.demo06;

public class Demo06WaitAndNotify {
    public static void main(String[] args) {
        Object obj = new Object();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (obj) {
                        System.out.println("告诉老板要买的包子种类和数量");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("顾客吃包子~");
                        System.out.println("----------------------------");
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj) {
                        System.out.println("花了3秒做好包子后，告诉顾客包子做好了，可以吃了~");
                        obj.notify();
                    }
                }

            }
        }.start();
    }
}
