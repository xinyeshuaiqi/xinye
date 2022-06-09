package pers.wmx.springbootfreemarkerdemo.util.limiter;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author wangmingxin03
 * Created on 2022-06-09
 */
public class LeakyBucketLimiter {
    //流水速率  固定
    private double rate;
    //桶的大小
    private double burst;
    //最后更新时间
    private long refreshTime;
    //桶里面的水量
    private int water;

    public LeakyBucketLimiter(double rate, double burst) {
        this.rate = rate;
        this.burst = burst;
    }

    private void refreshWater() {
        LocalDateTime time = LocalDateTime.now(); //每秒生成
        int second = time.getSecond();

        water = (int) Math.max(0, water - (second - refreshTime) * rate);
        refreshTime = second;
    }

    public synchronized boolean tryAcquire() {
        refreshWater();

        if (water < burst) {
            water++;
            return true;
        } else {
            return false;
        }
    }

    public static final LeakyBucketLimiter LEAKY_BUCKET = new LeakyBucketLimiter(1, 5);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            LocalTime now = LocalTime.now();
            if (!LEAKY_BUCKET.tryAcquire()) {
                System.out.println(now + "被限流");
            } else {
                System.out.println(now + "正常执行方法");
            }
        }
    }

}
