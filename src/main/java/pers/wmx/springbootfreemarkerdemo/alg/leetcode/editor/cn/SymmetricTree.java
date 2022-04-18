package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1805 👎 0


import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//
//        return check(root, root);
//    }

//    private boolean check(TreeNode u, TreeNode v) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(u);
//        queue.offer(v);
//
//        while (!queue.isEmpty()) {
//            u = queue.poll();
//            v = queue.poll();
//
//            if (u == null && v == null) {
//                continue;
//            }
//
//            if (u == null || v == null || (u.val != v.val)) {
//                return false;
//            }
//
//            queue.offer(u.left);
//            queue.offer(v.right);
//
//            queue.offer(u.right);
//            queue.offer(v.left);
//        }
//
//        return true;
//    }

    // 第2遍
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//
//        return checkSymmetric(root, root);
//    }
//
//    private boolean checkSymmetric(TreeNode root1, TreeNode root2) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root1);
//        queue.offer(root2);
//
//        while (!queue.isEmpty()) {
//            TreeNode u = queue.poll();
//            TreeNode v = queue.poll();
//
//            if (u == null && v == null) {
//                continue;
//            }
//
//            if (u == null || v == null) {
//                return false;
//            }
//
//            if (u.val != v.val) {
//                return false;
//            }
//
//            queue.offer(u.left);
//            queue.offer(v.right);
//
//            queue.offer(u.right);
//            queue.offer(v.left);
//        }
//
//        return true;
//    }

    // 第三遍 递归写法
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return checkSymmetric(root, root);
    }

    private boolean checkSymmetric(TreeNode u, TreeNode v) {
        if (u == null && v == null) {
            return true;
        }

        if (u == null || v == null) {
            return false;
        }

        if (u.val != v.val) {
            return false;
        }

        TreeNode uLeft = u.left;
        TreeNode uRight = u.right;
        TreeNode vLeft = v.left;
        TreeNode vRight = v.right;

        return checkSymmetric(uLeft, vRight)
                && checkSymmetric(uRight, vLeft);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

} 

