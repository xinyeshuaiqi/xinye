package pers.wmx.springbootfreemarkerdemo;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Objects;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * @author: wangmingxin03
 * @date: 2020-09-09
 */
public class TestStream {
    public static void main(String[] args) {
        List<Integer> giftIds = ImmutableList.of(1, 2, 3);
        List<Integer> giftList = getGiftList(giftIds);

        if (giftList == null) {
            System.out.println(111);
        }

        System.out.println(giftList.size());
    }


    private static List<Integer> getGiftList(List<Integer> giftIds) {
        return giftIds.stream()
                .filter(i -> i < 0)
                .collect(toList());
    }
}
