package pers.wmx.springbootfreemarkerdemo.bytecode;

/**
 * @author wangmingxin03
 * Created on 2022-06-21
 */
public class ConstantMain {
    public void constant() {
        new Thread(() -> {
            System.out.println("666");
        }).start();
    }
}
