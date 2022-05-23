package pers.wmx.springbootfreemarkerdemo;

/**
 * @author wangmingxin03
 * Created on 2022-05-23
 */
public class Main0523 {
    public static void main(String[] args) {

    }

    public boolean isBalanceTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isBalanceTree(root.left)
                && isBalanceTree(root.right)
                && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}

class TreeNode {
    int val;

    TreeNode left;

    TreeNode right;
}
