package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 广度优先搜索 数组 动态规划 
// 👍 1884 👎 0


import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int coinChange(int[] coins, int amount) {
//        if (amount == 0) {
//            return 0;
//        }
//
//        Arrays.sort(coins);
//
//        int sum = 0;
//        int use = 0;
//        for (int i = coins.length - 1; i >= 0 ; i--) {
//            while (sum + coins[i] <= amount) {
//                sum += coins[i];
//                use++;
//            }
//
//            if (sum == amount) {
//                return use;
//            }
//        }
//
//        return -1;
//    }

        // 三种思路由浅入深，从递归到记忆化搜索到动态规划，即是算法效率的提升，也是思维的提升。

        // 递归   Time Limit Exceeded ！！！
//        private int res = Integer.MAX_VALUE;
//        public int coinChange(int[] coins, int amount) {
//            if (amount < 1) {
//                return 0;
//            }
//
//            findWay(coins, amount, 0);
//
//            if (res == Integer.MAX_VALUE) {
//                return  -1;
//            }
//
//            return res;
//        }
//
//        private void findWay(int[] coins, int amount, int count) {
//            if (amount < 0) {
//                return;
//            }
//
//            if (amount == 0) {
//                res = Math.min(count, res);
//            }
//
//            for (int i = 0; i < coins.length; i++) {
//                findWay(coins, amount - coins[i], count + 1);
//            }
//        }


        // 记忆化搜索
        public int coinChange(int[] coins, int amount) {

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 

