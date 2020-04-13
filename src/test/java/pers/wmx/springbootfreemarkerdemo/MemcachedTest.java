package pers.wmx.springbootfreemarkerdemo;

import lombok.extern.slf4j.Slf4j;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;

/**
 * @author: wangmingxin03
 * @date: 2020-04-13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MemcachedTest {

    @Autowired
    private MemcachedRunner memcachedRunner;

    @Test
    public void testMemcache() throws ExecutionException, InterruptedException {
        MemcachedClient memcachedClient = memcachedRunner.getClient();
        OperationFuture<Boolean> set = memcachedClient.set("hello", 1000, "world");
        System.out.println("set结果" + set.get());

        System.out.println("get" + memcachedClient.get("hello").toString());
    }


}
