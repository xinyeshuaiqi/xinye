package pers.wmx.springbootfreemarkerdemo.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangmingxin03
 * Created on 2021-12-14
 */
@Slf4j
public class ShutdownHookDemo {
    private static class ShutDownHook extends Thread {
        public void run() {
            log.info("shut down ... ");
        }
    }

    public static void main(String[] args) throws Exception {
        log.info("start ... ");
        Runtime.getRuntime().addShutdownHook(new ShutDownHook());
        Thread.sleep(5000);

        System.exit(0);
    }
}
