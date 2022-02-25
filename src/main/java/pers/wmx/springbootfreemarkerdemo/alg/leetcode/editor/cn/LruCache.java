package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
//
// 实现 LRUCache 类： 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 ke
//y-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 105 
// 最多调用 2 * 105 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 1940 👎 0


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache {
    public static void main(String[] args) {

    }

     class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
         DLinkedNode next;

         public DLinkedNode() {
         }

         public DLinkedNode(int key, int value) {
             this.key = key;
             this.value = value;
         }
     }

     Map<Integer, DLinkedNode> cache = new HashMap<>();
    int size;
    int capacity;

    DLinkedNode head;
    DLinkedNode tail;

    public LruCache (int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);

            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;

            if (size > capacity) {
                // 移除尾部
                DLinkedNode removeNode = removeTail();
                cache.remove(removeNode.key);
                --size;
                
            }
        }

        node.value = value;
        moveToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.pre;
        removeNode(node);
        return tail;
    }

    // 因为被访问了，所有放到双向链表头部
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }




    //leetcode submit region begin(Prohibit modification and deletion)

// 利用LinkedHashMap的解法
//class LRUCache extends LinkedHashMap<Integer, Integer> {
//
//    private int capacity;
//    public LRUCache(int capacity) {
//        super(capacity, 0.75F, true);
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        return super.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        super.put(key, value);
//    }
//
//    @Override
//    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//            return size() > capacity;
//    }
//
//    }



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

} 

