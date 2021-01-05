package cn.itcast.day04.demo10;

public class MethodMain {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.computerOn();
        Usb usb = new Mouse();
        computer.useDevice(usb);
        Keybroad keybroad = new Keybroad();
        computer.useDevice(keybroad);
        computer.computerOff();
    }
}
