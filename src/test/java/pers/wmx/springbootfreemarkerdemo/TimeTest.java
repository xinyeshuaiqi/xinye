package pers.wmx.springbootfreemarkerdemo;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

/**
 * @author: wangmingxin03
 * @date: 2020-05-19
 */
public class TimeTest {

    public static void main(String[] args) {
        DateTime nowTime= DateTime.now();

        int year = nowTime.getYear();
        System.out.println(year);
        int weekYear = nowTime.getWeekyear();
        System.out.println(weekYear);

        System.out.println(nowTime.getWeekOfWeekyear());
        System.out.println(nowTime.getDayOfWeek());
        System.out.println(nowTime.getDayOfYear());

        DateTime dateTime = new DateTime(
                2019, //year
                1,    // month
                1,    // day
                1,    // hour (midnight is zero)
                0,    // minute
                0,    // second
                0     // milliseconds
        );

        System.out.println(dateTime.getWeekyear());
        System.out.println(dateTime.getWeekOfWeekyear());

        DateTime lastWeek = dateTime.minusWeeks(1);
        System.out.println(lastWeek.getWeekyear());
        System.out.println(lastWeek.getWeekOfWeekyear());

    }
}
