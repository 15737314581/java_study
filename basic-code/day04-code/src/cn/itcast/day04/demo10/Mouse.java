package cn.itcast.day04.demo10;

public class Mouse implements Usb {
    @Override
    public void usbOn() {
        System.out.println("�����~");
    }

    @Override
    public void usbOff() {
        System.out.println("�ر����~");
    }

    public void  click() {
        System.out.println("������");
    }
}
