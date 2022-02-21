package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
//使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 4329 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 去除重复解
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null) {
            return result;
        }

        int len = nums.length;
        if (len < 3) {
            return result;
        }

        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                // 大于0，就不可能找到合为0的了
                return result;
            }

            if (i > 0 && nums[i] == nums[i-1]) {
                // 去除掉重复解！！！
                continue;
            }

            // 以i为基准，去找另外2孤儿。。
            int left = i + 1;  // 1
            int right = len - 1;  // 2

            while (left < right) {
                // 刚才出了个问题就是没有写temp
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == 0) {
                    // 找到一组
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[left]);
                    item.add(nums[right]);

                    result.add(item);

                    // 在这里继续去除重复解
                    while (left < right && nums[left] == nums[left + 1]) {
                        ++ left; // 2
                    }

                    while (left <right && nums[right] == nums[right -1]) {
                        -- right;
                    }

                    ++ left; // 3
                    -- right;
                }

                if (temp > 0) {
                    -- right;
                }

                if (temp < 0) {
                    ++ left;
                }
            }


        } 

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
