package cn.itcast.day04.demo10;

public class Computer {
    public void computerOn() {
        System.out.println("打开笔记本电脑~");
    }

    public void computerOff() {
        System.out.println("关闭笔记本电脑~");
    }

    public void useDevice(Usb usb) {
        usb.usbOn();
        if (usb instanceof Mouse) {
            Mouse mouse = (Mouse)usb;
            mouse.click();
        } else if (usb instanceof Keybroad) {
            Keybroad keybroad = (Keybroad)usb;
            keybroad.type();
        }
        usb.usbOff();
    }
}
