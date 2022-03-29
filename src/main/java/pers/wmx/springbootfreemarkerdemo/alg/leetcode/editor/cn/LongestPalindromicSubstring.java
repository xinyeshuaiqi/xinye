package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 4882 👎 0


public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        int start = 0;
        int maxLen = 0;

    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        if (s.length() < 2) {
            return s;
        }

        // 从中心往两边扩展
        for (int i = 0; i < s.length(); i++) {
            findLongestPalindrome(s, i ,i);  // 奇数个
            findLongestPalindrome(s, i, i + 1);  // 偶数个
        }

        return s.substring(start, start + maxLen);
    }

        private void findLongestPalindrome(String s, int j, int k) {
            while(j >= 0
                    && k < s.length()
                    && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
            }

            int len = k - j - 1;

            if (len > maxLen) {
                maxLen = len;
                start = j + 1;
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

} 

