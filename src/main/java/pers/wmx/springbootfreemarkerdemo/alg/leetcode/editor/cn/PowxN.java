package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 递归 数学 
// 👍 916 👎 0


public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public double myPow(double x, int n) {
//        double result = 1;
//
//        for (int i = 0; i < n ; i++) {
//            result *= x;
//        }
//
//        return result;
//    }

        // 分治
    public double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        long N = n;

        // 处理指数是负数的情况
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

} 

