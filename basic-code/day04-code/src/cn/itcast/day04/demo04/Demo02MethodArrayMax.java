package cn.itcast.day04.demo04;

import java.util.Arrays;

public class Demo02MethodArrayMax {
    public static void main(String[] args) {
//        ȡ���������ֵ
//        int[] array = {10, 20, 15, 23, 18, 30, 19, 100, 70, 86};
//        int max = array[0];
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] > max) {
//                max = array[i];
//            }
//        }
//        System.out.println("���ֵΪ��" + max);

//        ������Ӵ�С����
        int[] array = {10, 20, 15, 23, 18, 30, 19, 100, 70, 86};
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length ; j++) {
                if (array[j] > array[i]) {
                    int max = array[i];
                    array[i] = array[j];
                    array[j] = max;
                }
            }
        }
        System.out.println(Arrays.toString(array));

    }
}
