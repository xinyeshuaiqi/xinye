package pers.wmx.springbootfreemarkerdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

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
        stringRedisTemplate.opsForValue().set("fpx","win");
    }
}
