package pers.wmx.springbootfreemarkerdemo;

import static java.time.LocalDateTime.ofInstant;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author: wangmingxin03
 * @date: 2020-05-27
 */
public class Test {
    private static final DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date(now));
        System.out.println(result1);

        System.out.println(timestampToDateStr(now));
    }

    private static String timestampToDateStr(long timestamp) {
        LocalDateTime localDateTime = ofInstant(Instant.ofEpochMilli(timestamp), TimeZone.getDefault().toZoneId());
        return dateTimeFormatter.format(localDateTime);
    }
}
