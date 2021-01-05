package cn.itcast.day04.demo10;

public class Mouse implements Usb {
    @Override
    public void usbOn() {
        System.out.println("打开鼠标~");
    }

    @Override
    public void usbOff() {
        System.out.println("关闭鼠标~");
    }

    public void  click() {
        System.out.println("点击鼠标");
    }
}
