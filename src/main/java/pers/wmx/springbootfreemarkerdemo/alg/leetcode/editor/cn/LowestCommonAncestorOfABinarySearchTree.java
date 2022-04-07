package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 792 👎 0


import pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinarySearchTree().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//        TreeNode cur = root;
//
//        while(true) {
//            // 一直往下深入
//            if (p.val < cur.val && q.val < cur.val) {
//                cur = cur.left;
//            } else if (p.val > cur.val && q.val > cur.val) {
//                cur = cur.right;
//            } else {
//                break;
//            }
//        }
//
//        return cur;
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int valMin = Math.min(p.val, q.val);
        int valMax = Math.max(p.val, q.val);

        return find(root, valMin, valMax);
    }

    private TreeNode find(TreeNode root, int valMin, int valMax) {
        if (root == null) {
            return null;
        }

        if (root.val > valMax) {
            return find(root.left, valMin, valMax);
        }

        if (root.val < valMin) {
            return find(root.right, valMin, valMax);
        }

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 

