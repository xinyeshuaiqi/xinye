package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
//
// 二叉搜索树的定义如下： 
//
// 
// 任意节点的左子树中的键值都 小于 此节点的键值。 
// 任意节点的右子树中的键值都 大于 此节点的键值。 
// 任意节点的左子树和右子树都是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
//输出：20
//解释：键值为 3 的子树是和最大的二叉搜索树。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [4,3,null,1,2]
//输出：2
//解释：键值为 2 的单节点子树是和最大的二叉搜索树。
// 
//
// 示例 3： 
//
// 
//输入：root = [-4,-2,-5]
//输出：0
//解释：所有节点键值都为负数，和最大的二叉搜索树为空。
// 
//
// 示例 4： 
//
// 
//输入：root = [2,1,3]
//输出：6
// 
//
// 示例 5： 
//
// 
//输入：root = [5,4,8,3,null,6,3]
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 每棵树有 1 到 40000 个节点。 
// 每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 动态规划 二叉树 
// 👍 88 👎 0


import pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn.TreeNode;

public class MaximumSumBstInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumSumBstInBinaryTree().new Solution();
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
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

//    1、左右子树是否是 BST。
//    2、左子树的最大值和右子树的最小值。
//    3、左右子树的节点值之和。

//    traverse(root) 返回一个大小为 4 的 int 数组，我们暂且称它为 res，其中：
//    res[0] 记录以 root 为根的二叉树是否是 BST，若为 1 则说明是 BST，若为 0 则说明不是 BST；
//    res[1] 记录以 root 为根的二叉树所有节点中的最小值；
//    res[2] 记录以 root 为根的二叉树所有节点中的最大值；
//    res[3] 记录以 root 为根的二叉树所有节点值之和。
    private int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[] {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        int[] res = new int[4];

        if (left[0] == 1 && right[0] ==1
                && root.val > left[2] && root.val < right[1]) {
            res[0] = 1;
            res[1] = Math.min(root.val, left[1]);
            res[2] = Math.max(root.val, right[2]);
            res[3] = root.val + left[3] + right[3];
            maxSum = Math.max(maxSum, res[3]);
        } else {
            // 左右子树有不是二叉搜索树的，那必然不是啊
            res[0] = 0;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 

