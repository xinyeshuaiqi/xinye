package pers.wmx.springbootfreemarkerdemo.bytecode;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.Super;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.implementation.bind.annotation.This;

/**
 * @author wangmingxin03
 * Created on 2022-06-29
 */
public class LogInterceptor {
    @RuntimeType
    public Object intercept(
            @This Object target,
            @Origin Method method,
            @AllArguments Object[] args,
            @Super Object delegate,
            @SuperCall Callable<?> callable) throws Exception {
        System.out.println("before ... method = " + method.getName());

        // 和Spring AOP 中的 ProceedingJoinPoint.proceed() 好像
        Object result = callable.call();

        System.out.println("after ... method = " + method.getName());
        return result;
    }
}
