package pers.wmx.springbootfreemarkerdemo;

import net.spy.memcached.MemcachedClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pers.wmx.springbootfreemarkerdemo.config.MemcacheSource;

import javax.annotation.Resource;
import java.net.InetSocketAddress;

/**
 * @author: wangmingxin03
 * @date: 2020-04-13
 */
@Component
public class MemcachedRunner implements CommandLineRunner {

    @Resource
    private MemcacheSource memcacheSource;

    private MemcachedClient client = null;

    @Override
    public void run(String... args) throws Exception {
        client = new MemcachedClient(new InetSocketAddress(memcacheSource.getIp(),memcacheSource.getPort()));
    }

    public MemcachedClient getClient(){
        return client;
    }
}
