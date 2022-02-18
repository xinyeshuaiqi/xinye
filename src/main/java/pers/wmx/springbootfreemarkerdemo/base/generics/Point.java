package pers.wmx.springbootfreemarkerdemo.base.generics;

/**
 * @author wangmingxin03
 * Created on 2022-02-18
 */
public class Point<T> {
    private T var;

    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }

    public static void main(String[] args) {
        // 由外部使用指定类型
        Point<String> point = new Point<>();
        point.setVar("xinye");
        System.out.print(point.getVar());
    }
}
