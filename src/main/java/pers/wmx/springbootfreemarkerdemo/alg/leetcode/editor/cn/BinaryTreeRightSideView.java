package pers.wmx.springbootfreemarkerdemo.alg.leetcode.editor.cn;//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 638 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
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

    // 最右边肯定是按层次遍历最后读到的数
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // 记录最右边的数据
        Map<Integer, Integer> depth2rightRecord = new HashMap<>();

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<Integer> depthQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        depthQueue.offer(0);

        int maxDepth = -1;

        while (!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.remove();
            int curDepth = depthQueue.remove();

            depth2rightRecord.put(curDepth, curNode.val);
            maxDepth = Math.max(curDepth, maxDepth);

            if (curNode.left != null) {
                nodeQueue.offer(curNode.left);
                depthQueue.offer(curDepth + 1);
            }

            if (curNode.right != null) {
                nodeQueue.offer(curNode.right);
                depthQueue.offer(curDepth + 1);
            }

        }

        for (int i = 0; i <= maxDepth; i++) {
            result.add(depth2rightRecord.get(i));
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

} 

