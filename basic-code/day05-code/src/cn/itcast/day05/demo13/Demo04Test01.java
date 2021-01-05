package cn.itcast.day05.demo13;

import java.util.function.Supplier;

public class Demo04Test01 {
    public static void main(String[] args) {
       int[] arr = {100,30,45,121,50,-160};
        int max1 = getMax(() -> {
            int max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println(max1);
    }

    public static int getMax(Supplier<Integer> sup){
        return sup.get();
    }
}
