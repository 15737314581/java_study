package test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DataTest {
    public static void main(String[] args) {
//        Date date = new Date();
//        System.out.println(date);
//        System.out.println(date.getTime());

        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);
//        System.out.println(today);
//        System.out.println(today.getYear());
//        System.out.println(today.getMonth());
//        System.out.println(today.getMonthValue());
//        System.out.println(today.getDayOfMonth());
//        System.out.println(today.getDayOfWeek());
//        System.out.println("==============");
//        LocalDateTime changeday = today.plusYears(1);
//        System.out.println(changeday.getYear());
//        System.out.println(changeday.isAfter(today));

//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String today_str = dtf.format(today);
//        System.out.println(today_str);

        LocalDateTime aftertime = LocalDateTime.of(2021, 06, 13, 13, 14, 00);
        System.out.println(aftertime);
        Duration duration = Duration.between(today, aftertime);
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());


    }
}
