package pers.wmx.springbootfreemarkerdemo.bytecode;

import static net.bytebuddy.matcher.ElementMatchers.isDeclaredBy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author wangmingxin03
 * Created on 2022-06-29
 */
public class Foo {
    public String aha() {
        System.out.println("doing ...");
        return "result";
    }
    public String foo() { return null; }
    public String foo(String str) { return null; }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Foo foo = new ByteBuddy()
                .subclass(Foo.class)
                .method(isDeclaredBy(Foo.class))
                .intercept(FixedValue.value("all method"))
                .method(ElementMatchers.named("foo"))
                .intercept(FixedValue.value("foo call"))
                .method(ElementMatchers.named("foo").and(ElementMatchers.takesArguments(1)))
                .intercept(FixedValue.value("foo call 1 arg"))
                .make()
                .load(Foo.class.getClassLoader())
                .getLoaded()
                .newInstance();

        System.out.println(foo.aha());
        System.out.println(foo.foo());
        System.out.println(foo.foo("nima"));
    }
}
