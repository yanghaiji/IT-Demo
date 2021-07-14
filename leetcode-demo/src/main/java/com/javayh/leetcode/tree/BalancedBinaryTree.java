package com.javayh.leetcode.tree;

/**
 * <p>
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-25
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        BalancedBinaryTree tree = new BalancedBinaryTree();

        TreeNode p2 = new TreeNode(2);
        TreeNode p4= new TreeNode(5);
        TreeNode p3 = new TreeNode(3,null,p4);
        TreeNode p = new TreeNode(1,p2,p3);

        System.out.println(tree.isBalanced(p));
    }

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *
     * 本题中，一棵高度平衡二叉树定义为：
     *
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            // 判断整棵树是不是平衡二叉树
            return Math.abs(height(root.left) - height(root.right)) < 2
                    //判断左右树是不是平衡二叉树
                    && isBalanced(root.left)
                    && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
