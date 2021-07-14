package com.javayh.leetcode.tree;

/**
 * <p>
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-25
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        /**
         * 给定一个二叉树，找出其最小深度。
         *
         * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
         *
         * 说明：叶子节点是指没有子节点的节点。
         */
        TreeNode p2 = new TreeNode(2);
        TreeNode p4= new TreeNode(5);
        TreeNode p3 = new TreeNode(3,null,p4);
        TreeNode p = new TreeNode(1,p2,p3);
        MinimumDepthOfBinaryTree tree = new MinimumDepthOfBinaryTree();
        tree.minDepth(p);
    }

    /**
     * 求二叉树的最下深度
     * @param root 二叉树
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        // 由于 二叉树的深度不确定，暂时使用 Integer 的最大值
        int maxValue = Integer.MAX_VALUE;
        //int min = Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        //递归求出左侧最小值
        if(root.left != null){
            maxValue = Math.min(minDepth(root.left), maxValue);
        }
        //递归求出右侧最小值
        if(root.right != null){
            maxValue = Math.min(minDepth(root.right), maxValue);
        }
        // 在求出 左右两个节点的最小值后在加上父节点的值
        return maxValue + 1;
    }
}
