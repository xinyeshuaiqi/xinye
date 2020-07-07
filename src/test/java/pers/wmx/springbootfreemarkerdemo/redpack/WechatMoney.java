package pers.wmx.springbootfreemarkerdemo.redpack;

/**
 * @author: wangmingxin03
 * @date: 2020-07-07
 */
public class WechatMoney {

    public static void main(String[] args) {
        double total_money; // 红包总金额
        int total_people; // 抢红包总人数
        double min_money; // 每个人最少能收到0.01元

        total_money = 10.0;
        total_people = 8;
        min_money = 0.01;

        for (int i = 0; i < total_people - 1; i++) {
            int j = i + 1;
            double safe_money = (total_money - (total_people - j) * min_money)
                    / (total_people - j);
            double tmp_money = (Math.random()
                    * (safe_money * 100 - min_money * 100) + min_money * 100) / 100;
            total_money = total_money - tmp_money;

            System.out.format("第 %d 个红包： %.2f 元，剩下： %.2f 元\n", j, tmp_money,
                    total_money);
        }
        System.out.format("第 %d 个红包： %.2f 元，剩下： 0 元\n", total_people,
                total_money);
    }


    /**
     * 第 1 个红包： 0.68 元，剩下： 9.32 元
     * 第 2 个红包： 0.55 元，剩下： 8.78 元
     * 第 3 个红包： 0.27 元，剩下： 8.51 元
     * 第 4 个红包： 1.17 元，剩下： 7.33 元
     * 第 5 个红包： 2.02 元，剩下： 5.31 元
     * 第 6 个红包： 2.46 元，剩下： 2.85 元
     * 第 7 个红包： 0.67 元，剩下： 2.18 元
     * 第 8 个红包： 2.18 元，剩下： 0 元
     * */

}
