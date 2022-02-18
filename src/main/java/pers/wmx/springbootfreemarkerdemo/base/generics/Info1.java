package pers.wmx.springbootfreemarkerdemo.base.generics;

/**
 * 泛型上限
 *
 * @author wangmingxin03
 * Created on 2022-02-18
 */
public class Info1<T extends Number> { // 此处泛型只能是数字类型
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        // Info1<String> info  Type parameter 'java.lang.String' is not within its bound; should extend 'java.lang.Number'

        Info1<Long> info1 = new Info1<>();
        info1.setT(1234567L);
        System.out.println(info1.getT());
    }
}
