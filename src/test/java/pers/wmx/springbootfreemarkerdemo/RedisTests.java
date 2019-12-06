package pers.wmx.springbootfreemarkerdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author wmx
 * @date 2019-11-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testString(){
        stringRedisTemplate.opsForValue().set("haha","hehe");
    }

    @Test
    public void testPipelined(){
        List<Object> objects = stringRedisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {

                connection.set("super carry".getBytes(), "doinb".getBytes());
                connection.set("tian".getBytes(), "神僧".getBytes());

                connection.get("super carry".getBytes());
                connection.get("tian".getBytes());

                return null;
            }
        });
        System.out.println(objects);
    }

    @Test
    public void testTransaction(){
        stringRedisTemplate.setEnableTransactionSupport(true);
        stringRedisTemplate.opsForValue().set("1","a");
        stringRedisTemplate.opsForValue().set("2","b");
        stringRedisTemplate.opsForValue().set("3","c");
    }
}

