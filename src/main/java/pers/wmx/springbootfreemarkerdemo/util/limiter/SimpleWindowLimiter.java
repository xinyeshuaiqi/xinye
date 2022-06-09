package pers.wmx.springbootfreemarkerdemo.util.limiter;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangmingxin03
 * Created on 2022-06-09
 */
public class SimpleWindowLimiter {
    private static int qps = 2;

    // 时间窗口（毫秒）
    private static long TIME_WINDOWS = 1000;

    // 计数器
    private static AtomicInteger REQ_COUNT = new AtomicInteger();

    private static long START_TIME = System.currentTimeMillis();

    public static synchronized boolean tryAcquire() {
        if (System.currentTimeMillis() - START_TIME > TIME_WINDOWS) {
            START_TIME = System.currentTimeMillis();
            REQ_COUNT.set(0);
        }

        return REQ_COUNT.incrementAndGet() <= qps;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(400L);

        for (int i = 0; i < 10; i++) {
            Thread.sleep(250L);

            LocalTime now = LocalTime.now();
            if (!tryAcquire()) {
                System.out.println(now + " limit");
            } else {
                System.out.println(now + " go");
            }
        }

    }
    

}
