package pers.wmx.springbootfreemarkerdemo.base.generics;

/**
 * 泛型接口
 *
 * @author wangmingxin03
 * Created on 2022-02-18
 */
public class InfoImpl<T> implements Info<T>{
    private T val;

    public InfoImpl(T val) {
        this.val = val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    @Override
    public T getVal() {
        return this.val;
    }

    public static void main(String[] args) {
        Info<String> info = new InfoImpl<>("nima");
        System.out.println(info.getVal());
    }
}
