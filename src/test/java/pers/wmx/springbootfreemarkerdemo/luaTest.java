package pers.wmx.springbootfreemarkerdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

/**
 * @author wmx
 * @date 2019-12-10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class luaTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    DefaultRedisScript<Boolean> luaScript;

    @Test
    public void testLua(){
        String key = "testLua";

        redisTemplate.delete(key);
        redisTemplate.opsForValue().set(key, "test CAS");
        String s = redisTemplate.opsForValue().get(key).toString();
        System.out.println(s);

        redisTemplate.execute(luaScript, Collections.singletonList(key), "test CAS", "666");
        //redisTemplate.execute(luaScript, Collections.singletonList(key), "test CAS 1", "666");
        s = redisTemplate.opsForValue().get(key).toString();
        System.out.println(s);
    }
}
