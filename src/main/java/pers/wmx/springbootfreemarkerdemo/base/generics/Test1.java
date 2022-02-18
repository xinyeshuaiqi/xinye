package pers.wmx.springbootfreemarkerdemo.base.generics;

import java.util.List;

/**
 * 泛型的上下限
 *
 * @author wangmingxin03
 * Created on 2022-02-18
 */
public class Test1 {
    public static  void f1(List<A> listA) {

    }

    public static  void f2(List<B> listB) {
        // f1(listB); 报错！！！
    }

    // ...

    // <? extends A>表示该类型参数可以是A(上边界)或者A的子类类型。
    // 编译器知道类型参数的范围，如果传入的实例类型B是在这个范围内的话允许转换，这时只要一次类型转换就可以了，运行时会把对象当做A的实例看待。
    public static void f3(List<? extends A> listA) {

    }

    public static void f4(List<B> listB) {
        f3(listB);
    }


}
