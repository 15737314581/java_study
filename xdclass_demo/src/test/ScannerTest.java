package test;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入：");
            String input = scanner.nextLine();
            if ("886".equalsIgnoreCase(input)) {
                System.out.println("程序结束");
                break;
            } else {
                System.out.println("你输入的内容是：" + input);
            }
        }
        scanner.close();
    }
}
