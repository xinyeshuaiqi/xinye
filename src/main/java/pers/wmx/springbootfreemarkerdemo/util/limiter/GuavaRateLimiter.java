package pers.wmx.springbootfreemarkerdemo.util.limiter;

import java.time.LocalTime;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author wangmingxin03
 * Created on 2022-06-09
 */
public class GuavaRateLimiter {
    // 每秒产生 10 个令牌（每 100 ms 产生一个）
    public static final RateLimiter RATE_LIMITER = RateLimiter.create(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 11; i++) {
            new Thread(() -> {
                LocalTime now = LocalTime.now();
                // 尝试获取 1 个令牌
                if (!RATE_LIMITER.tryAcquire()) {
                    System.out.println(now + "-被限流");
                } else {
                    System.out.println(now + "-正常执行方法");
                }
            }).start();
            Thread.sleep(50L);
        }
    }
}
