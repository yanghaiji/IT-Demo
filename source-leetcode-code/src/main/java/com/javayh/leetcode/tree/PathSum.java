package com.javayh.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * https://leetcode-cn.com/problems/path-sum/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-25
 */
public class PathSum {
    public static void main(String[] args) {
        /**
         * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，
         * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
         *
         * 叶子节点 是指没有子节点的节点。
         */
    }


    /**
     * 递归实现
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    /**
     *     广度优先搜索
     *
     */
    public boolean hasPathSumQueue(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }
}
