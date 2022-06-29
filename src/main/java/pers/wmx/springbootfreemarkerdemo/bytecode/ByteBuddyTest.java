package pers.wmx.springbootfreemarkerdemo.bytecode;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author wangmingxin03
 * Created on 2022-06-29
 */
@Slf4j
public class ByteBuddyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> loadType = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.named("toString"))  // 需要拦截的方法
                .intercept(FixedValue.value("hello world")) //拦截做的事情->FixedValue固定值返回
                .make() // 产生字节码
                .load(ByteBuddyTest.class.getClassLoader()) // 加载类
                .getLoaded(); // 获得class对象

        String result = loadType.newInstance().toString();
        log.info("result:{}", result);
    }
}
