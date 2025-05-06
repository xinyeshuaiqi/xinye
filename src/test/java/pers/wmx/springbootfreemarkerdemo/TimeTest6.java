package pers.wmx.springbootfreemarkerdemo;

import java.util.concurrent.TimeUnit;

/**
 * @author wangmingxin03
 * Created on 2022-09-02
 */
public class TimeTest6 {
    public static void main(String[] args) {
        // 1
        System.out.println(calculateDays(1746512450000L, 1746516050000L));

        // 2
        System.out.println(calculateDays(1746512450000L, 1746598850000L));

        // 2
        System.out.println(calculateDays(1746512450000L, 1746602450000L));

        // 2
        System.out.println(calculateDays(1746460800000L, 1746547200000L));
    }

    private static int calculateDays(long startTime, long endTime) {
        if (startTime <= 0 || endTime <= 0) {
            return 0;
        }

        if (endTime <= startTime) {
            return 0;
        }

        return (int) ((endTime - startTime) / TimeUnit.DAYS.toMillis(1) + 1);
    }

}
