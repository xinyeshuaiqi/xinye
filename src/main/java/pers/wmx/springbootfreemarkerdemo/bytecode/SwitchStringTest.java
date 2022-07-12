package pers.wmx.springbootfreemarkerdemo.bytecode;

/**
 * @author wangmingxin03
 * Created on 2022-07-12
 */
public class SwitchStringTest {
    public int test(String str) {
        switch (str) {
            case "Java":
                return 1;
            case "Go":
                return 2;
            default:
                return 0;
        }
    }

}
