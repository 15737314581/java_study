package cn.itcast.day05.demo07;

public class Demo01 {
    public static void main(String[] args) {
        Baozi bz = new Baozi();
        new BaoziPu(bz).start();
        new Chihuo(bz).start();
    }
}
