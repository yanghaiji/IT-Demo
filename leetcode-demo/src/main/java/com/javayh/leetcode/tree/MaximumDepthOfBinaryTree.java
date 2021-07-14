package com.javayh.leetcode.tree;

/**
 * <p>
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-24
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        /**
         * 给定一个二叉树，找出其最大深度。
         * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
         * 说明: 叶子节点是指没有子节点的节点。
         */
        /**
         * 这是一个深度运算
         * 求出左子树 与 右子树的最大值然后 在加 1
         */
        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();

        /**
         *              1
         *         2           3
         *                          5
         */
        TreeNode p2 = new TreeNode(2);
        TreeNode p4= new TreeNode(5);
        TreeNode p3 = new TreeNode(3,null,p4);
        TreeNode p = new TreeNode(1,p2,p3);
        
        System.out.println(tree.maxDepth(p));

    }

    /**
     * 深度优先
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
