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
//        int [] memo;
//        public int coinChange(int[] coins, int amount) {
//            if (coins.length == 0) {
//                return -1;
//            }
//
//            memo = new int[amount];
//            return findWay(coins, amount);
//        }

        // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
        // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
//        private int findWay(int[] coins, int amount) {
//            if (amount < 0) {
//                return -1;
//            }
//
//            if (amount == 0) {
//                return 0;
//            }
//
//            if (memo[amount - 1] != 0) {
//                return memo[amount - 1];
//            }
//
//            int min = Integer.MAX_VALUE;
//            for (int i = 0; i < coins.length; i++) {
//
//                //F(S)=F(S−C)+1
//
//                int res = findWay(coins, amount - coins[i]);
//
//                if (res >= 0 && res < min ) {
//                    min = res + 1;
//                }
//            }
//
//            memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
//            return memo[amount - 1];
//        }


        // 记忆搜索法 第二遍

        // 记录每个金额需要的个数、不需要重复计算
//        int []countMem;
//        public int coinChange(int[] coins, int amount) {
//            if (coins.length == 0) {
//                return 0;
//            }
//
//            countMem = new int[amount];
//            return findAmountWayCount(coins, amount);
//        }
//
//        private int findAmountWayCount(int[] coins, int amount) {
//            if (amount < 0) {
//                return -1;
//            }
//
//            if (amount == 0) {
//                return 0;
//            }
//
//            if (countMem[amount - 1] != 0) {
//                return countMem[amount - 1];
//            }
//
//            int min = Integer.MAX_VALUE;
//            for (int i = 0; i < coins.length; i++) {
//                int res = findAmountWayCount(coins, amount - coins[i]);
//
//                if (res >= 0 && res < min) {
//                    min = res + 1;
//                }
//            }
//
//            countMem[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
//            return countMem[amount - 1];
//        }

//         记忆搜索法 第三遍
//        int []amountCountMemory;
//        public int coinChange(int[] coins, int amount) {
//            if (coins.length == 0) {
//                return 0;
//            }
//
//            amountCountMemory = new int[amount + 1];
//            return findAmountCountWay(coins, amount);
//        }
//
//        private int findAmountCountWay(int[] coins, int amount) {
//            if (amount < 0) {
//                return -1;
//            }
//
//            if (amount == 0) {
//                return 0;
//            }
//
//            if (amountCountMemory[amount] != 0) {
//                return amountCountMemory[amount];
//            }
//
//            int min = Integer.MAX_VALUE;
//            for (int i = 0; i < coins.length; i++) {
//                int res = findAmountCountWay(coins, amount - coins[i]);
//
//                // 找到一个最小的解法
//                if (res >= 0 && res < min) {
//                    min = res + 1;
//                }
//            }
//
//            amountCountMemory[amount] = (min == Integer.MAX_VALUE ? -1 : min);
//            return amountCountMemory[amount];
//        }


//        public int coinChange(int[] coins, int amount) {
//            // DP[i]代表凑成金额i所需最小硬币数，-1代表没法凑成
//            int[] DP = new int[amount + 1];
//            Arrays.fill(DP, -1);
//            // 0只需要0个硬币
//            DP[0] = 0;
//            // 遍历
//            for (int i = 1; i <= amount; i++) {
//                // 对每个硬币，如果符合条件都 DP[i-c] + 1都可以作为 DP[i]候选
//                for (int c : coins) {
//                    if (i < c || DP[i - c] == -1) continue;
//                    if (DP[i] == -1 || DP[i] > DP[i - c] + 1) DP[i] = DP[i - c] + 1;
//                }
//            }
//            return DP[amount];
//        }

        // 动态规划
//        public int coinChange(int[] coins, int amount) {
//            int []dp = new int[amount + 1];
//            Arrays.fill(dp, -1);
//
//            dp[0] = 0;
//            for (int i = 1; i <= amount; i++) {
//                for (int coin : coins) {
//                    if (coin > i) {
//                        // 当前这个币值太大
//                        continue;
//                    }
//
//                    if (dp[i - coin] == -1) {
//                        // 用了coin后剩下的钱没法组成了
//                        continue;
//                    }
//
//                    if (dp[i] == -1 || dp[i] > dp[i - coin] + 1) {
//                        dp[i] = dp[i - coin] + 1;
//                    }
//                }
//            }
//
//            return dp[amount];
//        }

        // 动态规划第二遍
       public int coinChange(int[] coins, int amount) {
           if (coins.length == 0) {
               return 0;
           }

           if (amount == 0) {
               return 0;
           }

           if (amount < 0) {
               return -1;
           }

           int []amountCountRecord = new int[amount + 1];
           Arrays.fill(amountCountRecord, -1);
           amountCountRecord[0] = 0;

           for (int i = 1; i <= amount; i++) {
                // 去看从组装金额1到金额amount分币最少需要多少个硬币

               for(int currentCoin : coins) {
                    if (currentCoin > i) {
                        // 当前硬币金额太大啦
                        continue;
                    }

                    if (amountCountRecord[i - currentCoin] == -1){
                        // 用了当前硬币，但是剩余的硬币没法组装了
                        continue;
                    }

                    if (amountCountRecord[i] == -1
                            || amountCountRecord[i] > amountCountRecord[i - currentCoin] + 1) {
                        amountCountRecord[i] = amountCountRecord[i - currentCoin] + 1;
                    }
               }

           }

           return  amountCountRecord[amount];
       }

    }
//leetcode submit region end(Prohibit modification and deletion)

} 

