package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// 
// 
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 
// 👍 1185 👎 0


import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        return generateTreeAllDiffTrees(1, n);
    }

    private List<TreeNode> generateTreeAllDiffTrees(int low, int high) {
        List<TreeNode> res = new ArrayList<>();

        if (low > high) {
            // 这里要塞一个空值，左子树为空，也要参与下面的left list的遍历构建树
            res.add(null);
            return res;
        }

        for (int i = low; i <= high ; i++) {
            // 以i为根节点，分左右子树

            List<TreeNode> left = generateTreeAllDiffTrees(low, i - 1);
            List<TreeNode> right = generateTreeAllDiffTrees(i + 1, high);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 

