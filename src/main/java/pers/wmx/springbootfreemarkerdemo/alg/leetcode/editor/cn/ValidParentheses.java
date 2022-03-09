package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 3056 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Map<Character, Character> parentheses = new HashMap<>();

    {
        parentheses.put('(', ')');
        parentheses.put('[', ']');
        parentheses.put('{', '}');
    }

    public boolean isValid(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }

        Stack<Character> queue = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (queue.isEmpty()) {
                queue.push(s.charAt(i));
            } else {
                Character top = queue.peek();
                Character right = parentheses.get(top);

                if (right != null && right == s.charAt(i)) {
                    queue.pop();
                } else {
                    queue.push(s.charAt(i));
                }
            }
        }

        return queue.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 

