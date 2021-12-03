package pers.wmx.springbootfreemarkerdemo.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangmingxin03
 * Created on 2021-12-03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ZkTest {
    @Autowired
    private ZooKeeper zkClient;

    @Test
    public void testInsert() {
        try {
            zkClient.create("/hello/hello1", "zk".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (Exception e) {
            log.error("create node fail ... ", e);
        }
    }

    @Test
    public void testQuery() {
        try {
            Stat stat = new Stat();
            byte[] bytes = zkClient.getData("/hello", false, stat);
            log.info("query result:{}", new String(bytes));
        } catch (Exception e) {
            log.error("query fail ... ", e);
        }
    }

}
