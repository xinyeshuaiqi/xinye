package pers.wmx.springbootfreemarkerdemo.base.generics;

/**
 * @author wangmingxin03
 * Created on 2022-02-18
 */
public interface Info<T> {
    // 定义抽象方法，抽象方法的返回值就是泛型类型
    T getVal();
}
