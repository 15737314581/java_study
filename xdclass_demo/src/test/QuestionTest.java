package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class QuestionTest {
    public static void main(String[] args) {
        test1();

    }

    public static void test1(){
        String str = "*Constructs a new <tt>HashMap</tt> ⼩滴课堂 with the same mappings as the *" +
                "⼩滴课堂 specified <tt>Map</tt>. The <tt>HashMap</tt> is created with default" +
                "load factor (0.75) and an initial capacity sufficient to*hold the mappings" +
                "in the specified <tt>Map</tt>.";
        char[] charArray = str.toCharArray();
        Map<Character, Integer> counterMap = new HashMap<>();
        for (char c : charArray) {
            Integer values = counterMap.get(c);
            if (values == null){
                counterMap.put(c,1);
            }else {
                values++;
                counterMap.put(c,values);
            }
        }

        Set<Map.Entry<Character, Integer>> entries = counterMap.entrySet();

        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.println(entry.getKey()+"字符的个数为："+entry.getValue());

        }


    }
}
