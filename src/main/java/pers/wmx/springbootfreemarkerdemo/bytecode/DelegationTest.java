package pers.wmx.springbootfreemarkerdemo.bytecode;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author wangmingxin03
 * Created on 2022-06-29
 */
public class DelegationTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        // 委托方法
        String delegationResult = new ByteBuddy()
                .subclass(Source.class)
                .method(ElementMatchers.named("hello"))
                .intercept(MethodDelegation.to(Target.class))
                .make()
                .load(DelegationTest.class.getClassLoader())
                .getLoaded()
                .newInstance()
                .hello("wmx");
        System.out.println(delegationResult);
    }
}
