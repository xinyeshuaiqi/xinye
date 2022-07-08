package pers.wmx.springbootfreemarkerdemo.bytecode;

/**
 * @author wangmingxin03
 * Created on 2022-07-08
 */

// 测试lambda表达式
public class LambdaTest1 {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("nima...");

        // pers.wmx.springbootfreemarkerdemo.bytecode.LambdaTest1$$Lambda$1/849460928
        System.out.println(task.getClass().getName());
        task.run();
    }
}
