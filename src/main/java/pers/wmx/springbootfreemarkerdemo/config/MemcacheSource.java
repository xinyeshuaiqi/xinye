package pers.wmx.springbootfreemarkerdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: wangmingxin03
 * @date: 2020-04-13
 */
@Component
public class MemcacheSource {
    @Value("${memcache.ip}")
    private String ip;

    @Value("${memcache.port}")
    private int port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
