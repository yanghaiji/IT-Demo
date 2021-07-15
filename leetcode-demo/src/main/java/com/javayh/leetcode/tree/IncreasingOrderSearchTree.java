package com.javayh.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-04-25
 */
public class IncreasingOrderSearchTree {
    public static void main(String[] args) {

        TreeNode l = new TreeNode(1);
        TreeNode r = new TreeNode(7);
        TreeNode treeNode = new TreeNode(5,l,r);
        System.out.println(increasingBST(treeNode));
    }

    static List<TreeNode> list = new ArrayList<>();

    public static TreeNode increasingBST(TreeNode root) {
        dfs(root);
        TreeNode dummy = new TreeNode(-1);
        TreeNode cur = dummy;
        for (TreeNode node : list) {
            cur.right = node;
            node.left = null;
            cur = node;
        }
        return dummy.right;
    }

    static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }


}
