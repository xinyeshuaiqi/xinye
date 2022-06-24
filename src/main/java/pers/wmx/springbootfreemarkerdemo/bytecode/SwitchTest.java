package pers.wmx.springbootfreemarkerdemo.bytecode;

/**
 * @author wangmingxin03
 * Created on 2022-06-24
 */
public class SwitchTest {
    int choose(int i) {
        switch (i) {
            case 100:   return 0;
            case 101:   return 1;
            case 104:   return 4;
            case 105:   return 5;
            default:    return -1;
        }
    }
}
