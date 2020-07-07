package pers.wmx.springbootfreemarkerdemo.redpack;

import java.util.Random;

/**
 * @author: wangmingxin03
 * @date: 2020-07-07
 */
public class RandomTest {

    public static void main(String[] args) {
        RedPackage redPackage = new RedPackage();
        redPackage.remainMoney = 100;
        redPackage.remainSize = 10;

        while (redPackage.remainSize > 0) {
            double randomMoney = getRandomMoney(redPackage);
            System.out.println(randomMoney);
        }
    }


    /**
     * 抢红包最重要的莫过于拆包
     * 拆的金额要保证尽可能随机，还要保证不能出现资损
     * 还要包
     *
     * 为啥要  金额 / 红包数 * 2 我现在还没搞明白
     *
     * 可见 数学还是得好啊。。。
     *
     * 先抢后抢拿到红包的大小的期望是大致相等的，所以还是先下手抢吧
     * 后抢的人方差大（依赖前面人抢的多少），波动较大，有较大几率拿到手气最佳
     *
     * 前面的人抢的越少，后面的抢的越多 （remainMoney大，产生大的随机值可能就大）
     *
     **/
    public static double getRandomMoney(RedPackage redPackage) {
        // remainSize 剩余的红包数量
        // remainMoney 剩余的钱
        if (redPackage.remainSize == 1) {
            redPackage.remainSize--;
            return (double) Math.round(redPackage.remainMoney * 100) / 100;
        }

        Random r     = new Random();
        double min   = 0.01;
        double max   = redPackage.remainMoney / redPackage.remainSize * 2;
        double money = r.nextDouble() * max;    //13.252960381435447
        money = money <= min ? 0.01: money;
        money = Math.floor(money * 100) / 100;  //13.25
        redPackage.remainSize--;
        redPackage.remainMoney -= money;  // 100 - 13.25 =86.75
        return money;
    }


}


class RedPackage {
    int id;
    int userId;
    int remainSize;
    long remainMoney;
}