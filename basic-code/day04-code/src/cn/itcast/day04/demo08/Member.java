package cn.itcast.day04.demo08;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member() {
    }

    public Member(String name, int leftMoney) {
        super(name, leftMoney);
    }

    public void receive(ArrayList<Integer> arrayList) {
        Random r = new Random();
        int index = r.nextInt(arrayList.size());
        int delta = arrayList.remove(index);
        int sumMoney = super.getLeftMoney() + delta;
        super.setLeftMoney(sumMoney);
    }
}
