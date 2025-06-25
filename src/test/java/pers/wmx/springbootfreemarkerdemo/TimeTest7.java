package pers.wmx.springbootfreemarkerdemo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author wangmingxin03
 * Created on 2022-09-02
 */
public class TimeTest7 {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter FMT_DD = DateTimeFormatter.ofPattern("dd");

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        printTime(1750759200000L);
    }

    public static void printTime(long timestamp) {
        LocalDateTime localDateTime =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
        LocalDate localDate = localDateTime.toLocalDate();
        int secondOfDay = localDateTime.toLocalTime().toSecondOfDay();
        int sequence = secondOfDay / 600;

        int sequenceNew = secondOfDay / 86400;

        System.out.println(localDate.format(FMT));
        System.out.println(secondOfDay);
        System.out.println(sequence);
        System.out.println(sequenceNew);
    }
}
