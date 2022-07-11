package pers.wmx.springbootfreemarkerdemo.bytecode;

/**
 * @author wangmingxin03
 * Created on 2022-07-11
 */
public class NumIncreTest {
    public static void main(String[] args) {

        int num = 0;
        for (int i = 0; i < 50; i++) {
            num = num++;
        }

        System.out.println(num);  // 0
    }

}
