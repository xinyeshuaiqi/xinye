package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 617 👎 0


import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // 先校验前n个
        for (int i = 0; i < n; i++) {
            ++count1[s1.charAt(i) - 'a'];
            ++count2[s2.charAt(i) - 'a'];
        }

        if (Arrays.equals(count1, count2)) {
            return true;
        }

        // 滑动窗口
        // 从n 到 m看
        for (int i = n; i < m; i++) {
            // 往右移
            ++ count2[s2.charAt(i) - 'a'];
            -- count2[s2.charAt(i - n) - 'a'];

            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 

