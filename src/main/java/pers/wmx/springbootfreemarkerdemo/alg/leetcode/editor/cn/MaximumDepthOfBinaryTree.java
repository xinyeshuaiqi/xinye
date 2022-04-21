package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1145 👎 0


import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
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

// 104
class Solution {
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int leftDepth = maxDepth(root.left);
//        int rightDepth = maxDepth(root.right);
//        return Math.max(leftDepth,rightDepth) + 1;
//    }


    // 深度遍历
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int leftDepth = maxDepth(root.left);
//        int rightDepth = maxDepth(root.right);
//        return Math.max(leftDepth, rightDepth) + 1;
//    }

    // 广度遍历
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }

                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }

            depth++;
        }

        return depth;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

} 

