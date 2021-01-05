package cn.itcast.day04.demo10;

public class Computer {
    public void computerOn() {
        System.out.println("�򿪱ʼǱ�����~");
    }

    public void computerOff() {
        System.out.println("�رձʼǱ�����~");
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
