package cn.itcast.day04.demo07;

public class Demo01StringEquals {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        char[] charArray = {'a', 'b', 'c'};
        String str3 = new String(charArray);
        System.out.println(str1 == str2); // true
        System.out.println(str1 == str3); // false
        System.out.println(str1.equals(str2)); // true
        System.out.println(str1.equals(str3)); // true
        System.out.println(str1.equals("abc")); // true --²»ÍÆ¼ö
        System.out.println("abc".equals(str1)); // true --ÍÆ¼ö
        String str4 = "Abc";
        System.out.println(str1.equals(str4)); // false
        System.out.println(str1.equalsIgnoreCase(str4)); // true
        System.out.println(str1.equalsIgnoreCase("ABC")); // true



    }
}

