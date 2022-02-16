package pers.wmx.springbootfreemarkerdemo.alg.sort;

/**
 * 循环队列
 *
 * @author wangmingxin03
 * Created on 2022-02-10
 */
public class CircularQueue {
    private String[] items;

    private int n = 0;

    private int head = 0;

    private int tail = 0;

    /**
     * 初始化队列，head = tail = 0, 队列为空
     **/
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        if ((tail + 1) % n == head) {
            // 队列满了，循环队列尾追上了队列头
            return false;
        }

        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            // 空队列
            return null;
        }

        String item = items[head];
        head = (head + 1) % n;
        return item;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }
}
