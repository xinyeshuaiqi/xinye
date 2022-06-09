package pers.wmx.springbootfreemarkerdemo.util.limiter;

import redis.clients.jedis.Jedis;

/**
 * @author wangmingxin03
 * Created on 2022-06-09
 */
public class SlidingWindowLimiter {
    private static final Jedis JEDIS_CLIENT = new Jedis("39.97.47.254", 6668);

    private static boolean isPeriodLimiting(String key, int period, int maxCount) {
        long now = System.currentTimeMillis();

        JEDIS_CLIENT.zremrangeByScore(key, 0, now - period * 1000);
        long currentCount = JEDIS_CLIENT.zcard(key);

        if (currentCount >= maxCount) {
            return false;
        }

        JEDIS_CLIENT.zadd(key, now, "" + now);
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            boolean res = isPeriodLimiting("java", 3, 2);
            if (res) {
                System.out.println(System.currentTimeMillis() + " go");
            } else {
                System.out.println(System.currentTimeMillis() + " limit");
            }
        }

        // 休眠 2s
        Thread.sleep(2000L);
        boolean res = isPeriodLimiting("java", 3, 2);
        if (res) {
            System.out.println("休眠后，正常执行请求");
        } else {
            System.out.println("休眠后，被限流");
        }
    }
}