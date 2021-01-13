package pers.wmx.springbootfreemarkerdemo;

import org.joda.time.DateTime;

/**
 * @author wangmingxin03
 * Created on 2020-12-16
 */
public class TimeTest2 {

    public static void main(String[] args) {
        long dataVersion = getDataVersion(System.currentTimeMillis());
        System.out.println(dataVersion);
    }



    private static long getDataVersion(long now) {
        DateTime nowTime = new DateTime(now);
        long weekYear = nowTime.getWeekyear();
        long weekOfWeekYear = nowTime.getWeekOfWeekyear();
        return weekYear * 100 + weekOfWeekYear;
    }
}
