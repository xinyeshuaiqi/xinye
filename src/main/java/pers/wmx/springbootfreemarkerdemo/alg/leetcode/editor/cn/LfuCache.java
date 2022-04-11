package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
//
// 实现 LFUCache 类： 
//
// 
// LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象 
// int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。 
// void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量 capac
//ity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。 
// 
//
// 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。 
//
// 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入：
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "g
//et"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//输出：
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//解释：
//// cnt(x) = 键 x 的使用计数
//// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
//LFUCache lfu = new LFUCache(2);
//lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lfu.get(1);      // 返回 1
//                 // cache=[1,2], cnt(2)=1, cnt(1)=2
//lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
//                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//lfu.get(2);      // 返回 -1（未找到）
//lfu.get(3);      // 返回 3
//                 // cache=[3,1], cnt(3)=2, cnt(1)=2
//lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
//                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//lfu.get(1);      // 返回 -1（未找到）
//lfu.get(3);      // 返回 3
//                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//lfu.get(4);      // 返回 4
//                 // cache=[3,4], cnt(4)=2, cnt(3)=3 
//
// 
//
// 提示： 
//
// 
// 0 <= capacity <= 104 
// 0 <= key <= 105 
// 0 <= value <= 109 
// 最多调用 2 * 105 次 get 和 put 方法 
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 520 👎 0


import java.util.HashMap;
import java.util.LinkedHashSet;

public class LfuCache {
    public static void main(String[] args) {

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class LFUCache {

        // key 到 val 的映射，我们后文称为 KV 表
        HashMap<Integer, Integer> keyToVal;

        // key 到 freq 的映射，我们后文称为 KF 表
        HashMap<Integer, Integer> keyToFreq;

        // freq 到 key 列表的映射，我们后文称为 FK 表
        HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

        // 记录最小的频次
        int minFreq;

        // 记录 LFU 缓存的最大容量
        int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }
    
    public int get(int key) {
        if (!keyToFreq.containsKey(key)) {
            return -1;
        }

        increaseFreq(key);
        return keyToFreq.get(key);
    }

        private void increaseFreq(int key) {
            int freq = keyToFreq.get(key);
            keyToFreq.put(key, freq + 1);

            freqToKeys.get(freq).remove(key);
            freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
            freqToKeys.get(freq + 1).add(key);

            // 如果 freq 对应的列表空了，移除掉。。。
            LinkedHashSet<Integer> freqItems = freqToKeys.get(freq);
            if (freqItems.isEmpty()) {
                freqToKeys.remove(freq);

                if (freq == this.minFreq) {
                    this.minFreq++;
                }
            }
        }

        private void removeMinFreqKey() {
            LinkedHashSet<Integer> curFreqItems = freqToKeys.get(minFreq);

            // 干掉第一个
            int deleteKey = curFreqItems.iterator().next();
            curFreqItems.remove(deleteKey);

            if (curFreqItems.isEmpty()) {
                freqToKeys.remove(minFreq);
            }

            keyToVal.remove(deleteKey);
            keyToFreq.remove(deleteKey);
        }


        public void put(int key, int value) {
            if (this.cap <= 0) {
                return;
            }

            if (keyToVal.containsKey(key)) {
                keyToVal.put(key, value);
                increaseFreq(key);
                return;
            }

            // 容器满啦
            if (this.cap <= keyToVal.size()) {
                removeMinFreqKey();
            }

            keyToVal.put(key, value);
            keyToFreq.put(key, 1);

            freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
            freqToKeys.get(1).add(key);

            this.minFreq = 1;

    }


    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

} 

