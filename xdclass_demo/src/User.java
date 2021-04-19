
import java.util.Date;

/**
 * 文档注释
 *
 * @author jjf
 * @version 1.0
 */
public class User {
    /*
     * 定义一个方法
     */
    public void sleep() {
        // 多行注释
        System.out.println("我要睡觉了1");
        System.out.println("我要睡觉了2");
        System.out.println("我要睡觉了3");
        System.out.println("我要睡觉了4");
        System.out.println("我要睡觉了5");



    }

    public static void main(String[] args) {
        User user = new User();
        user.sleep();
        Date date = new Date();
        System.out.println(date);

    }
}
