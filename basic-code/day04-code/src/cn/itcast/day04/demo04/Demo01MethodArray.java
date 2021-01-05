package cn.itcast.day04.demo04;

public class Demo01MethodArray {
    public static void main(String[] args) {
        int[] array = new int[3];
        System.out.println(array);
        System.out.println(array[0]);
        array[0] = 1;
        System.out.println(array[0]);
        int[] arrayA = new int[] {1, 2, 3};
        String[] arrayB = {"Hello", "World", "HaHa"};
        System.out.println(arrayA[2]);
        System.out.println(arrayB[2]);
    }
}
