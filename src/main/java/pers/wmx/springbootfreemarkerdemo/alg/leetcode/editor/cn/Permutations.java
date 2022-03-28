package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1854 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> track = new LinkedList<>();
            boolean[] used = new boolean[nums.length];

            track(nums, track, used);
            return result;
        }

        // 没有想象中的那么难，不要慌。。。
        private void track(int[] nums, LinkedList<Integer> track, boolean[] used) {
            if (nums.length == track.size()) {
                result.add(new LinkedList<>(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }

                // 加进去
                track.add(nums[i]);
                used[i] = true;
                track(nums, track, used);

                // 再干掉
                track.removeLast();
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 

