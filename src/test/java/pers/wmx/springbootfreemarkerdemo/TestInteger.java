package pers.wmx.springbootfreemarkerdemo;

/**
 * @author: wangmingxin03
 * @date: 2020-05-29
 */
public class TestInteger {

    public static void main(String[] args) {
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        System.out.println(i1 == i2 + i3); // true

        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        System.out.println(i4 == i5 + i6); // true


        Integer i11 = null;
        Integer i22 = 40;
        int i33 = 40;
        System.out.println(i11 == i22); // false
        //System.out.println(i11 == i33); // NPE  自动拆箱


        Double d1 = 1.2;
        Double d2 = 1.2;
        System.out.println(d1 == d2); // false  Double没有常量池

        Double d = 1.0;
        int i = 1;
        System.out.println(d == i); // true   Double 和 int 比较，先转换为 double 后再比较

    }

}
