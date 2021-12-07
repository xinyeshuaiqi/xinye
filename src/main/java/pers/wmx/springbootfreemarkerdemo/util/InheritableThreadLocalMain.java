package pers.wmx.springbootfreemarkerdemo.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangmingxin03
 * Created on 2021-12-07
 */
@Slf4j
public class InheritableThreadLocalMain {
    // 可以传递给子线程
    private static  final InheritableThreadLocal<Integer> THREAD_LOCAL = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        int traceId = 1;
        THREAD_LOCAL.set(traceId);
        log.info("父线程 threadLocal:{}", THREAD_LOCAL.get());

        // 开启子线程 （如果用普通的ThreadLocal，子线程是读不到的，线程间隔离的）
        new Thread(() -> {
            log.info("子线程 threadLocal:{}", THREAD_LOCAL.get());
        }).start();

    }

}
