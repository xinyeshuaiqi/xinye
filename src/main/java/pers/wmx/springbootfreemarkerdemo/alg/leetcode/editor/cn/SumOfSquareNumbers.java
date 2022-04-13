package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
//
// 
//
// 示例 1： 
//
// 
//输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 
//输入：c = 3
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 231 - 1 
// 
// Related Topics 数学 双指针 二分查找 
// 👍 343 👎 0


public class SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfSquareNumbers().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        // i、j和result的定义要变成long, 用int不会通过
    public boolean judgeSquareSum(int c) {
        long i = 0;
        long j = (int) Math.sqrt(c);

        while (i <= j) {
            long result = i * i + j * j;
            if (result == c) {
                return true;
            } else if (result < c) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 

