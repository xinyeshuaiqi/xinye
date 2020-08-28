package pers.wmx.springbootfreemarkerdemo;

import static com.google.common.collect.BoundType.CLOSED;
import static com.google.common.collect.BoundType.OPEN;
import static com.google.common.collect.Range.range;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

/**
 * @author: wangmingxin03
 * @date: 2020-08-27
 */
public class TestRangeMap {

    public static void main(String[] args) {
        RangeMap<Long, Long> scoreGrade = TreeRangeMap.create();


        scoreGrade.put(range(1l, CLOSED, 10l, OPEN), 1l);  //1-10分的1级
        scoreGrade.put(range(10l, CLOSED, 20l, OPEN), 2l);
        scoreGrade.put(range(20l, CLOSED, 30l, OPEN), 3l);

        //......

        scoreGrade.put(Range.atLeast(1000l), 999l);   //1000分以上的 999级


        Long curGrade = scoreGrade.get(25l);
        System.out.println(curGrade);

        Long curGrade1 = scoreGrade.get(2000l);
        System.out.println(curGrade1);
    }

}
