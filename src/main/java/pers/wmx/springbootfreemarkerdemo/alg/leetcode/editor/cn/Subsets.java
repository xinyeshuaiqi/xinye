package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 
// 👍 1551 👎 0


import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        private List<List<Integer>> result = new ArrayList<>();

        private List<Integer> t = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return result;
    }

    private void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            result.add(new ArrayList<>(t));
            return;
        }

        // 要当前的这个元素
        t.add(nums[cur]);
        dfs(cur + 1, nums);

        // 不要当前这个元素
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }


    }
//leetcode submit region end(Prohibit modification and deletion)

} 

