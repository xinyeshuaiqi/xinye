package pers.wmx.springbootfreemarkerdemo;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.util.Lists;

/**
 * @author wangmingxin03
 * Created on 2022-07-20
 */
public class CollectionTest {
    public static void main(String[] args) {
        List<Integer> list = Lists.list(1, 3, 5, 8, 11, 21, 50,999);

        long hourTime = DateUtils.truncate(new Date(), Calendar.HOUR).getTime();
        System.out.println(hourTime);

        Collections.shuffle(list, new Random(hourTime));
        System.out.println(list);
        // [21, 999, 8, 5, 3, 50, 1, 11]  传seed可以让shuffle的结果一致

    }


}
