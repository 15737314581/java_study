package cn.itcast.day05.demo13;

public class Demo02Runner {
    public static void main(String[] args) {
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "--->������");
            }
        });

        startThread(()->{
            System.out.println(Thread.currentThread().getName() + "--->������");;
        });
    }


    public static void startThread(Runnable run){
        new Thread(run).start();
    }



}
