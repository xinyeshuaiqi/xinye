package pers.wmx.springbootfreemarkerdemo.bytecode;

/**
 * @author wangmingxin03
 * Created on 2022-07-11
 */
public class NumIncreTest2 {
    public static void main(String[] args) {
        int num = 0;

        num = num++ + ++num;
        System.out.println(num);
    }
}
