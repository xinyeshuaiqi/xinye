package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 数组 哈希表 分治 计数 排序 
// 👍 1327 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//
//        int low = 0;
//        int high = nums.length - 1;
//        int mid = (low + high) / 2;
//
//        // 出现超过一半的数一定是排好序中间的那个数
//        return nums[mid];
//    }

//    public int majorityElement(int[] nums) {
//        // 超过一半的数一定是出现最多的那个数
//        Map<Integer, Integer> record = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            int count = record.getOrDefault(nums[i], 0);
//            record.put(nums[i], ++count);
//        }
//
//        int maxNum = -1;
//        int maxCount = 0;
//        for(Map.Entry<Integer, Integer> e: record.entrySet()) {
//            if (e.getValue() > maxCount) {
//                maxCount = e.getValue();
//                maxNum = e.getKey();
//            }
//        }
//
//        return maxNum;
//    }


        // 抵消法 最多的元素一定存活到最后
    public int majorityElement(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (queue.isEmpty()) {
                queue.offer(nums[i]);
            } else {
                int temp = queue.peek();
                if (temp != nums[i]) {
                    queue.poll();
                } else {
                    queue.offer(nums[i]);
                }
            }
        }

        return queue.peek();
    }

//    public int majorityElement(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            max = Math.max(max, nums[i]);
//        }
//
//        int []arr = new int[max + 1];
//
//        for (int i = 0; i < nums.length; i++) {
//            arr[nums[i]] ++;
//        }
//
//        int result = 0;
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > count) {
//                result = i;
//                count = arr[i];
//            }
//        }
//
//        return result;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 

