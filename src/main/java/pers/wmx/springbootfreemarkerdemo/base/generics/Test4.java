package pers.wmx.springbootfreemarkerdemo.base.generics;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * @author wangmingxin03
 * Created on 2022-02-23
 */
public class Test4 {
    // 泛型擦除
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        // true
        // 说明泛型类型String和Integer都被擦除掉了，只剩下原始类型。
        System.out.println(list1.getClass() == list2.getClass());

        // 通过反射添加元素
        list2.getClass()
                .getMethod("add", Object.class)
                .invoke(list1, "nima");

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
    }
}
