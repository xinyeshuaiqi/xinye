package pers.wmx.springbootfreemarkerdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author: wangmingxin03
 * @date: 2020-09-02
 */
@Aspect
@Component
@Lazy
public class MyAspect {

    //切面
    @Pointcut("@annotation(pers.wmx.springbootfreemarkerdemo.aspect.ActionAspect)")
    public void access() {

    }

    //环绕
    @Around("access() && @annotation(actionAspect)")
    public Object doAround(ProceedingJoinPoint joinPoint, ActionAspect actionAspect) throws Throwable {
        System.out.println(actionAspect.value());

        //do something

        Object result = joinPoint.proceed();
        System.out.println(result);
        return result;
    }

}
