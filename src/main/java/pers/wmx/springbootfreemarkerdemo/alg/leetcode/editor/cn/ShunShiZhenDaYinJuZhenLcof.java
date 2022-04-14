package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 
// 👍 388 👎 0


public class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;

        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;

        while(true) {

            // left to right
            for (int i = l; i <= r; i++) {
                res[index++] = matrix[t][i];
            }

            if (++t > b) {
                break;
            }

            // top to bottom
            for (int i = t; i <= b; i++) {
                res[index++] = matrix[i][r];
            }

            if (l > --r) {
                break;
            }

            // right to left
            for (int i = r; i >= l ; i--) {
                res[index++] = matrix[b][i];
            }

            if (t > --b) {
                break;
            }

            // bottom to top
            for (int i = b; i >= t ; i--) {
                res[index++] = matrix[i][l];
            }

            if (++l > r) {
                break;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 

