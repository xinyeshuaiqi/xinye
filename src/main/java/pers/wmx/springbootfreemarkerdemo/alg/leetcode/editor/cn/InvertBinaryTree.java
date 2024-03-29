package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,3]
//输出：[2,3,1]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1196 👎 0


import java.util.LinkedList;
import java.util.Queue;

import pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
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
// 226
class Solution {
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//
//            TreeNode left = node.left;
//            node.left = node.right;
//            node.right = left;
//
//            if (node.left != null) {
//                queue.offer(node.left);
//            }
//
//            if (node.right != null) {
//                queue.offer(node.right);
//            }
//        }
//
//        return root;
//    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 如果去尝试脑补递归，会让自己变得像个傻子一样。。。
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

} 

