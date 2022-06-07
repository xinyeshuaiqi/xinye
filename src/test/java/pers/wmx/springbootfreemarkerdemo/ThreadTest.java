package pers.wmx.springbootfreemarkerdemo;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wangmingxin03
 * Created on 2022-06-07
 */
public class ThreadTest {
    public static void main(String[] args) {
        AtomicLong counter = new AtomicLong();

        while (true) {
            new Thread(() -> {
                try {
                    Thread.sleep(60000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            System.out.println("start thread ... " + counter.incrementAndGet());

            // 不变，说明占用的不是这部分空间
            System.out.println(Runtime.getRuntime().freeMemory());
        }

    }
}
