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
//        public int findKthLargest(int[] nums, int k) {
//            // 指定小顶堆大小 (底层是一个数组)
//            PriorityQueue<Integer> minHeap =
//                    new PriorityQueue<>(k, Comparator.comparing(a -> a));
//
//            // 先把前k个元素扔进去
//            for (int i = 0; i < k; i++) {
//                minHeap.offer(nums[i]);
//            }
//
//            for (int i = k; i < nums.length; i++) {
//                int maxNum = minHeap.peek();
//                if (nums[i] > maxNum) {
//                    minHeap.poll();
//                    minHeap.offer(nums[i]);
//                }
//            }
//
//            return minHeap.peek();
//        }

        // 可以用快排来找
        public int findKthLargest(int[] nums, int k) {
            // 转换k的语意，升序第n-k个
            k = nums.length - k;

            int low = 0;
            int high = nums.length - 1;

            while (low <= high) {
                int p = partition(nums, low, high);
                if (p < k) {
                    low = p + 1;
                } else if (p > k) {
                    high = p -1;
                } else {
                    return nums[p];
                }
            }

            return -1;
        }

        // 关键算法
        private int partition(int[] nums, int low, int high) {
            int key = nums[low];

            int i = low + 1;
            int j = high;

            // i自增，j自减
            while (i <= j) {
                while (i < high && nums[i] <= key) {
                    i++;
                }
                // 找到一个i位置的树大于key,跳出循环

                while (j >= low + 1 && nums[j] > key) {
                    j--;
                }
                // 找到一个j位置的树小于key,跳出循环

                // 此时 [lo, i) <= pivot && (j, hi] > pivot
                if (i >= j) {
                    break;
                }

                swap(nums, i, j);
            }

            // 基准归位
            swap(nums, low, j);
            return j;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] =  nums[j];
            nums[j] = temp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

} 

