package pers.wmx.springbootfreemarkerdemo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangmingxin03
 * Created on 2024-07-31
 */
public class TestMap {
    public static void main(String[] args) {
        Record r1 = new Record();
        r1.setId(9);
        r1.setBizId(1);
        Record r2 = new Record();
        r2.setId(8);
        r2.setBizId(2);
        Record r3 = new Record();
        r3.setId(6);
        r3.setBizId(1);
        Record r4 = new Record();
        r4.setId(3);
        r4.setBizId(1);

        List<Record> list = new ArrayList<>();
        list.add(r1);
        list.add(r2);
        list.add(r3);
        list.add(r4);

        Map<Long, List<Record>> collect = list.stream().collect(Collectors.groupingBy(Record::getBizId));
        System.out.println(collect);

    }
}
