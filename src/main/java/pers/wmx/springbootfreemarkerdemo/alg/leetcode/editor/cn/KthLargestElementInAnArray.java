package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1496 👎 0


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int findKthLargest(int[] nums, int k) {
//        // 时间复杂度消耗在排序上
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//    }

        // 使用堆
        // 在Java里使用优先级队列
        public int findKthLargest(int[] nums, int k) {
            // 指定小顶堆大小 (底层是一个数组)
            PriorityQueue<Integer> minHeap =
                    new PriorityQueue<>(k, Comparator.comparing(a -> a));

            // 先把前k个元素扔进去
            for (int i = 0; i < k; i++) {
                minHeap.offer(nums[i]);
            }

            for (int i = k; i < nums.length; i++) {
                int maxNum = minHeap.peek();
                if (nums[i] > maxNum) {
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }

            return minHeap.peek();
        }

}
//leetcode submit region end(Prohibit modification and deletion)

} 

