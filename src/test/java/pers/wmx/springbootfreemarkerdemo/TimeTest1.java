package pers.wmx.springbootfreemarkerdemo;

import org.joda.time.DateTime;

/**
 * @author wangmingxin03
 * Created on 2020-12-11
 */
public class TimeTest1 {
    public static void main(String[] args) {
        long timeStamp = System.currentTimeMillis();
        int basicClock = 6;
        long millis = new DateTime(timeStamp).minusHours(basicClock).millisOfDay().withMinimumValue().minusHours(-basicClock)
                .getMillis();

        System.out.println(timeStamp);
        System.out.println(millis);   //今天早上6点


        // 11号下午4点多跑，minusHours 17 就定到10号
        DateTime.Property property = new DateTime(timeStamp).minusHours(17).millisOfDay();
        System.out.println(property.withMinimumValue());   //2020-12-10T00:00:00.000+08:00

        System.out.println(property.withMinimumValue().minusHours(-17).getMillis());
    }
}
