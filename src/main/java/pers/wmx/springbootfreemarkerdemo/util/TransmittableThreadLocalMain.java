package pers.wmx.springbootfreemarkerdemo.util;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangmingxin03
 * Created on 2021-12-07
 */
@Slf4j
public class TransmittableThreadLocalMain {
    private static final TransmittableThreadLocal<Integer> THREAD_LOCAL = new TransmittableThreadLocal<>();

    // 线程复用也可以传递
    private static  final ExecutorService threadPool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10 ; i++) {
            // 模拟10次请求
            new TomcatThread(i).start();
        }

        Thread.sleep(3000);
        threadPool.shutdown();
    }

    static class TomcatThread extends Thread {
        int index;

        public TomcatThread(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            log.info(name + ":" + index);
            THREAD_LOCAL.set(index);

            threadPool.submit(Objects.requireNonNull(TtlRunnable.get(new BusinessThread(name))));
        }
    }

    static class BusinessThread implements Runnable {
        private String parentThreadName;

        public BusinessThread(String parentThreadName) {
            this.parentThreadName = parentThreadName;
        }

        @Override
        public void run() {
            log.info("parentThreadName:" + parentThreadName + ":" + THREAD_LOCAL.get());
        }
    }
}


