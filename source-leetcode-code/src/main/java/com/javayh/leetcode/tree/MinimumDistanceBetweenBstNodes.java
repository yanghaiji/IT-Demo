package com.javayh.leetcode.tree;

/**
 * <p>
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-04-13
 */
public class MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {

        TreeNode left = new TreeNode(7);
        TreeNode right = new TreeNode(9);
        TreeNode root = new TreeNode(5, left, right);
        System.out.println(minDiffInBST(root));
    }

    /**
     * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
     *
     * @param root
     * @return
     */
    static int pre;
    static int ans;

    public static int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    /**
     * 中序遍历实现
     * @param root
     */
    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != -1) {
            ans = Math.min(ans, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }
}


