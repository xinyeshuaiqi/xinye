package pers.wmx.springbootfreemarkerdemo;

import java.util.concurrent.TimeUnit;

/**
 * @author wangmingxin03
 * Created on 2022-09-02
 */
public class TimeTest4 {
    public static void main(String[] args) {

        // 2770141 [10点10分-10点20分]
        // 2770142 [10点20分-10点30分]
        System.out.println(System.currentTimeMillis() / TimeUnit.MINUTES.toMillis(10));
    }

}
