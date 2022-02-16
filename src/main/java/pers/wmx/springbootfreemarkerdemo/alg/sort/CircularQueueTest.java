package pers.wmx.springbootfreemarkerdemo.alg.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangmingxin03
 * Created on 2022-02-10
 */
@Slf4j
public class CircularQueueTest {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        log.info(queue.getHead() + "-" + queue.getTail());

        log.info(queue.dequeue());
        log.info(queue.dequeue());
        log.info(queue.dequeue());

        log.info(queue.getHead() + "-" + queue.getTail());

        queue.enqueue("g");
        queue.enqueue("h");
        queue.enqueue("i");

        log.info(queue.getHead() + "-" + queue.getTail());
    }
}
