package pers.wmx.springbootfreemarkerdemo.bytecode

/**
 * @author wangmingxin03* Created on 2022-07-07
 */
class Test {
    def add(a, b) {
        // new Exception().printStackTrace();

        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(add("hello ", "world"))
    }
}
