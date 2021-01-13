package pers.wmx.springbootfreemarkerdemo;

import static java.time.Instant.ofEpochMilli;
import static java.time.LocalDateTime.of;
import static java.time.LocalDateTime.ofInstant;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.TimeZone;

/**
 * @author wangmingxin03
 * Created on 2020-12-21
 */
public class TimeTest3 {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        LocalDateTime createDateTime = ofInstant(ofEpochMilli(now),
                TimeZone.getDefault().toZoneId());
        LocalDateTime createNextDateTime = createDateTime.plusDays(1);
        LocalDateTime timeoutDateTime = of(createNextDateTime.getYear(),
                createNextDateTime.getMonth(), createNextDateTime.getDayOfMonth(),
                6, 0);

        long wishListTimeoutTime = Timestamp.valueOf(timeoutDateTime).getTime();
        System.out.println(wishListTimeoutTime);
    }
}
