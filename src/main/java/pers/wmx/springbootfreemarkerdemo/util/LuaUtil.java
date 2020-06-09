package pers.wmx.springbootfreemarkerdemo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

/**
 * @author wmx
 * @date 2019-12-10
 */
@Component
public class LuaUtil {
    @Bean
    DefaultRedisScript<Boolean> luaScript() {
        DefaultRedisScript<Boolean> luaScript = new DefaultRedisScript<>();
        luaScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("test.lua")));
        luaScript.setResultType(Boolean.class);
        return luaScript;
    }
}
