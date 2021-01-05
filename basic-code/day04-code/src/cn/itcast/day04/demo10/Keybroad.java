package cn.itcast.day04.demo10;

public class Keybroad implements Usb {
    @Override
    public void usbOn() {
        System.out.println("´ò¿ª¼üÅÌ~");
    }

    @Override
    public void usbOff() {
        System.out.println("¹Ø±Õ¼üÅÌ~");
    }

    public void type() {
        System.out.println("ÊäÈë¼üÅÌ~");
    }
}
