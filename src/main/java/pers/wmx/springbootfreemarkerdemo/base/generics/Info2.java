package pers.wmx.springbootfreemarkerdemo.base.generics;

/**
 * @author wangmingxin03
 * Created on 2022-02-18
 */
public class Info2<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Info2<Object> i1 = new Info2();
        Info2<String> i2 = new Info2();

        i1.setT(new Object());
        i2.setT("NIMA");

        fun(i1);
        fun(i2);

        Info2<Integer> i3 = new Info2();
        // fun(i3); 报错！！！
    }

    public static void fun(Info2<? super String> info) {  // 泛型下限 --- 只能接收String或Object类型的泛型，String类的父类只有Object类

    }
}
