package pers.wmx.springbootfreemarkerdemo

import lombok.extern.slf4j.Slf4j
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.DataAccessException
import org.springframework.data.redis.connection.RedisConnection
import org.springframework.data.redis.core.RedisCallback
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.test.context.junit4.SpringRunner

/**
 * @author wmx
 * @date 2019-11-22
 */
@RunWith(SpringRunner::class)
@SpringBootTest
@Slf4j
class RedisTests {
    @Autowired
    private val stringRedisTemplate: StringRedisTemplate? = null

    @Test
    fun testString() {
        stringRedisTemplate!!.opsForValue().set("haha", "hehe")
    }

    @Test
    fun testPipelined() {
        val objects = stringRedisTemplate!!.executePipelined { connection ->
            connection.set("super carry".toByteArray(), "doinb".toByteArray())
            connection.set("tian".toByteArray(), "神僧".toByteArray())

            connection.get("super carry".toByteArray())
            connection.get("tian".toByteArray())

            null
        }
        println(objects)
    }

    @Test
    fun testTransaction() {
        stringRedisTemplate!!.setEnableTransactionSupport(true)
        stringRedisTemplate.opsForValue().set("1", "a")
        stringRedisTemplate.opsForValue().set("2", "b")
        stringRedisTemplate.opsForValue().set("3", "c")
    }
}

