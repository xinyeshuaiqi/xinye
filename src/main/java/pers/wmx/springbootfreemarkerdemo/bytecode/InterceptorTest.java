package pers.wmx.springbootfreemarkerdemo.bytecode;

import static net.bytebuddy.matcher.ElementMatchers.isDeclaredBy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;

/**
 * @author wangmingxin03
 * Created on 2022-06-29
 */
public class InterceptorTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Foo foo = new ByteBuddy()
                .subclass(Foo.class)
                .method(isDeclaredBy(Foo.class))
                .intercept(MethodDelegation.to(new LogInterceptor()))
                .make()
                .load(InterceptorTest.class.getClassLoader())
                .getLoaded()
                .newInstance();

        String result = foo.aha();
        System.out.println(result);
    }
}
