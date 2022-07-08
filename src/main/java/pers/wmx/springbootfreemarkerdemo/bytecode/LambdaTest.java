package pers.wmx.springbootfreemarkerdemo.bytecode;

/**
 * @author wangmingxin03
 * Created on 2022-07-08
 */
public class LambdaTest {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("nima...");
            }
        };

        task.run();
    }
}
