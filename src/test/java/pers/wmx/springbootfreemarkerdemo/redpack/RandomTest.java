package pers.wmx.springbootfreemarkerdemo.redpack;

import java.util.Random;

/**
 * @author: wangmingxin03
 * @date: 2020-07-07
 */
public class RandomTest {

    //手工去测下拆红包的算法
    public static void main(String[] args) {
        //一共5个红包，总额50

        Integer maxRandomAmount = 50 / 5 * 2;
        int randomAmount = new Random().nextInt(maxRandomAmount) + 1;
        System.out.println(randomAmount);  //第一个红包13

        maxRandomAmount = (50-13)/4 * 2;
        randomAmount = new Random().nextInt(maxRandomAmount) + 1;
        System.out.println(randomAmount);  //第二个红包11

        maxRandomAmount = (50-13-11)/3 * 2;
        randomAmount = new Random().nextInt(maxRandomAmount) + 1;
        System.out.println(randomAmount);  //第三个红包13

        maxRandomAmount = (50-13-11-13)/2 * 2;
        randomAmount = new Random().nextInt(maxRandomAmount) + 1;
        System.out.println(randomAmount);  //第四个红包6

        //最后一个红包
        randomAmount = 50-13-11-13-6;


        //红包分布大致均匀

        Random r  = new Random();
        double money = r.nextDouble() * (100 / 10 * 2) ;
        System.out.println(money);
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
    int remainSize;
    long remainMoney;
}