package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 6986 👎 0


import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> tempChars = new HashSet<>();

        int len = s.length();
        // 最大无重复子串长度
        int result = 0;
        int index = 0;

        for (int i = 0; i < len; i++) {
            if (i != 0) {
                // 移除前一个字符
                tempChars.remove(s.charAt(i - 1));
            }

            // aba
            while (index < len && !tempChars.contains(s.charAt(index))) {
                tempChars.add(s.charAt(index)); // a -> b 
                ++ index; // 1 -> 2
            }

            // 不停的找到回文子串长度
            result = Math.max(result, index - i);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 

