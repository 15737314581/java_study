package cn.itcast.day04.demo08;

import javax.swing.*;
import java.util.ArrayList;

public class MethodMain {
    public static void main(String[] args) {
        Manager manager = new Manager("Ⱥ��",200);
        Member member1 = new Member("С��", 0);
        Member member2 = new Member("С��", 0);
        Member member3 = new Member("С��", 0);
        manager.show();
        member1.show();;
        member2.show();
        member3.show();
        ArrayList<Integer> arrayList = manager.send(50, 3);
        member1.receive(arrayList);
        member2.receive(arrayList);
        member3.receive(arrayList);
        manager.show();
        member1.show();;
        member2.show();
        member3.show();
    }
}
