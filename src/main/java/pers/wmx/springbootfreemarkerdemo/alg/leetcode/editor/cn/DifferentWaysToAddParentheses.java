package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：expression = "2-1-1"
//输出：[0,2]
//解释：
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// 示例 2： 
//
// 
//输入：expression = "2*3-4*5"
//输出：[-34,-14,-10,-10,10]
//解释：
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20 
// expression 由数字和算符 '+'、'-' 和 '*' 组成。 
// 输入表达式中的所有整数值在范围 [0, 99] 
// 
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 
// 👍 544 👎 0


import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        Solution solution = new DifferentWaysToAddParentheses().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        if (expression == null || expression.length() == 0) {
            return result;
        }

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // 是运算符号
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for (int lItem : left) {
                    for (int rItem : right) {

                        int curResult = 0;
                        if (ch == '+') {
                            curResult = lItem + rItem;
                        } else if (ch == '-') {
                            curResult = lItem - rItem;
                        } else if (ch == '*') {
                            curResult = lItem * rItem;
                        }
                        result.add(curResult);
                    }
                }
            }
        }

        // 只剩数字啦，直接把这一个单数字加进结果
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 

