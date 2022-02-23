package pers.wmx.springbootfreemarkerdemo.base.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wangmingxin03
 * Created on 2022-02-23
 */
public class XComparable {
    // Comparable< ? super E> 要对 E 进行比较，即 E 的消费者，所以需要用 super
    // 而参数 List< ? extends E> 表示要操作的数据是 E 的子类的列表，指定上限，这样容器才够大
    private static <E extends Comparable<? super E>> E max(List<? extends E> e1) {
        if (e1 == null){
            return null;
        }
        //迭代器返回的元素属于 E 的某个子类型
        Iterator<? extends E> iterator = e1.iterator();
        E result = iterator.next();
        while (iterator.hasNext()){
            E next = iterator.next();
            if (next.compareTo(result) > 0){
                result = next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<AComparable> list = new ArrayList<>();
        AComparable a = new AComparable(2);
        AComparable b = new AComparable(1);
        AComparable c = new AComparable(5);
        list.add(a);
        list.add(b);
        list.add(c);

        AComparable maxA = max(list);
        System.out.println(maxA.getVal());
    }


}
