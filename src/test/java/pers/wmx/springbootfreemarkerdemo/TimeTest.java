package pers.wmx.springbootfreemarkerdemo;

import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;

/**
 * @author: wangmingxin03
 * @date: 2020-05-19
 */
public class TimeTest {

    public static void main(String[] args) {
        DateTime dateTime1 = new DateTime(
                2019, //year
                12,    // month
                31,    // day
                1,    // hour (midnight is zero)
                0,    // minute
                0,    // second
                0     // milliseconds
        );
        System.out.println("2019.12.31");
        System.out.println(dateTime1.getWeekyear());
        System.out.println(dateTime1.getWeekOfWeekyear());

        DateTime dateTime2 = new DateTime(
                2020, //year
                1,    // month
                1,    // day
                1,    // hour (midnight is zero)
                0,    // minute
                0,    // second
                0     // milliseconds
        );
        System.out.println("2020.1.1");
        System.out.println(dateTime1.getWeekyear());
        System.out.println(dateTime1.getWeekOfWeekyear());

        DateTime lastWeek = dateTime1.minusWeeks(1);
        System.out.println("2019.12.31的上一周");
        System.out.println(lastWeek.getWeekyear());
        System.out.println(lastWeek.getWeekOfWeekyear());


        DateTime time = DateTime.now();
        //获取周的第几天
        System.out.println(time.plusDays(2).getDayOfWeek());
        System.out.println(time.getWeekOfWeekyear());

        System.out.println(System.currentTimeMillis() / TimeUnit.MINUTES.toMillis(10));

        System.out.println((System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(10)) / TimeUnit.MINUTES.toMillis(10));
    }
}
