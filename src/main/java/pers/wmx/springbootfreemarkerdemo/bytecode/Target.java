package pers.wmx.springbootfreemarkerdemo.bytecode;

/**
 * @author wangmingxin03
 * Created on 2022-06-29
 */
public class Target {
    // FIXME: 这个为啥必须得加 static
    public static String hello(String name) {
        return "hello, " + name;
    }
}
