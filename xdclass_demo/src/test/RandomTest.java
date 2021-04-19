package test;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        boolean b = random.nextBoolean();
        System.out.println(b);
    }
}
