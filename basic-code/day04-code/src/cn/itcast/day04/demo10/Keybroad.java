package cn.itcast.day04.demo10;

public class Keybroad implements Usb {
    @Override
    public void usbOn() {
        System.out.println("�򿪼���~");
    }

    @Override
    public void usbOff() {
        System.out.println("�رռ���~");
    }

    public void type() {
        System.out.println("�������~");
    }
}
