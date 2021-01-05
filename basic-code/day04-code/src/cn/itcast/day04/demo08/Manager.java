package cn.itcast.day04.demo08;

import java.util.ArrayList;

public class Manager extends User {
    public Manager() {

    }

    public Manager(String name, int leftMoney) {
        super(name, leftMoney);
    }

    public ArrayList<Integer> send(int sendMoney, int count) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int managerMoney = super.getLeftMoney();
        if (managerMoney < sendMoney) {
            System.out.println("Óà¶î²»×ã~");
            return arrayList;
        }
        super.setLeftMoney(getLeftMoney() - sendMoney);
        int avgMoney = sendMoney / count;
        int yuMoney = sendMoney % count;
        for (int i = 0; i < count - 1; i++) {
            arrayList.add(avgMoney);
        }
        arrayList.add(avgMoney + yuMoney);
        return arrayList;
    }
}
