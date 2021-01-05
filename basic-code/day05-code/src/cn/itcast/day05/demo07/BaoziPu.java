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
                    bz.pi = "��Ƥ";
                    bz.xian = "������";
                } else {
                    bz.pi = "��Ƥ";
                    bz.xian = "�²˼���";
                }
                count++;
                System.out.println("������������"+bz.pi+bz.xian+"����");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(bz.pi+bz.xian+"�Ѿ������ˣ��Ի����Գ���");
                bz.status = true;
                bz.notify();
            }


        }
    }
}
