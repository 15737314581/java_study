package cn.itcast.day04.demo04;

import java.util.Arrays;
//将一个数组内容颠倒
public class Demo03MethodReverse {
    public static void main(String[] args) {
        int[] array = { 1,3,5,7,9,2};
        System.out.println(Arrays.toString(array));
        for (int min = 0, max = array.length - 1; min < max; min++, max--) {
            int tem = array[min];
            array[min] = array[max];
            array[max] = tem;
        }
        System.out.println(Arrays.toString(array));
    }
}
