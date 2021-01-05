package cn.itcast.day05.demo06;

public class Demo06WaitAndNotify {
    public static void main(String[] args) {
        Object obj = new Object();
        new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (obj) {
                        System.out.println("�����ϰ�Ҫ��İ������������");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("�˿ͳ԰���~");
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
                        System.out.println("����3�����ð��Ӻ󣬸��߹˿Ͱ��������ˣ����Գ���~");
                        obj.notify();
                    }
                }

            }
        }.start();
    }
}
