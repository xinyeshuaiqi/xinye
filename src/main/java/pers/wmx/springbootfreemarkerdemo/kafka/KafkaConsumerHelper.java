package pers.wmx.springbootfreemarkerdemo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangmingxin03
 * Created on 2021-12-15
 */
@Slf4j
@Service
public class KafkaConsumerHelper {
    private static final String TOPIC_NAME = "kafka-test";

    @KafkaListener(topics = TOPIC_NAME, groupId = "order-create")
    public void onMessage(OrderCreateMsg orderCreateMsg) {
        log.info("consume msg:{}", orderCreateMsg);
    }
}
