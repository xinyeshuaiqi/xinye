package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 2497 👎 0


import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return result;
        }

        dfs("", 0, 0, n);
        return result;
    }

        private void dfs(String cur, int left, int right, int n) {
            if (left == n && right == n) {
                result.add(cur);
                return;
            }

            if (left < right) {
                return;
            }

            if (left < n) {
                dfs(cur + "(", left + 1, right, n);
            }

            if (right < n) {
                dfs(cur + ")", left, right + 1, n);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 

