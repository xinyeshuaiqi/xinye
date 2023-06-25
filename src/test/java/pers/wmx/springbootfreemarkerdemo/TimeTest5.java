package pers.wmx.springbootfreemarkerdemo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author wangmingxin03
 * Created on 2022-09-02
 */
public class TimeTest5 {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {

        long timeStamp = System.currentTimeMillis();
        LocalDateTime localDateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timeStamp), ZoneId.systemDefault());

        System.out.println(localDateTime.format(FMT));


        System.out.println(0 % 1253463);

    }

}
