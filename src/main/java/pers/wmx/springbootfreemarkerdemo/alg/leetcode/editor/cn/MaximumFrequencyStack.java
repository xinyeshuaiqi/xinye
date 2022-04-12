package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。
//
// 实现 FreqStack 类: 
//
// 
// FreqStack() 构造一个空的堆栈。 
// void push(int val) 将一个整数 val 压入栈顶。 
// int pop() 删除并返回堆栈中出现频率最高的元素。
// 
// 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。 
// 
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"
//],
//[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
//输出：[null,null,null,null,null,null,null,5,7,5,4]
//解释：
//FreqStack = new FreqStack();
//freqStack.push (5);//堆栈为 [5]
//freqStack.push (7);//堆栈是 [5,7]
//freqStack.push (5);//堆栈是 [5,7,5]
//freqStack.push (7);//堆栈是 [5,7,5,7]
//freqStack.push (4);//堆栈是 [5,7,5,7,4]
//freqStack.push (5);//堆栈是 [5,7,5,7,4,5]
//freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
//freqStack.pop ();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
//freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
//freqStack.pop ();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。 
//
// 
//
// 提示： 
//
// 
// 0 <= val <= 109 
// push 和 pop 的操作数不大于 2 * 104。 
// 输入保证在调用 pop 之前堆栈中至少有一个元素。 
// 
// Related Topics 栈 设计 哈希表 有序集合 
// 👍 223 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class FreqStack {

        private int maxFreq = 0;

        // VF
        private Map<Integer, Integer> val2FreqMap;
        // FV
        private Map<Integer, Stack<Integer>> fre2ValMap;

        public FreqStack() {
            val2FreqMap = new HashMap<>();
            fre2ValMap = new HashMap<>();
        }
    
    public void push(int val) {
        int freq = val2FreqMap.getOrDefault(val, 0) + 1;
        val2FreqMap.put(val, freq);

        fre2ValMap.putIfAbsent(freq, new Stack<>());
        fre2ValMap.get(freq).add(val);

        maxFreq = Math.max(maxFreq, freq);
    }
    
    public int pop() {
        Stack<Integer> vals = fre2ValMap.get(maxFreq);
        int popV = vals.pop();

        int popFreq = val2FreqMap.get(popV) - 1;
        val2FreqMap.put(popV, popFreq);

        if (vals.isEmpty()) {
            maxFreq--;
        }

        return popV;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
//leetcode submit region end(Prohibit modification and deletion)

} 

