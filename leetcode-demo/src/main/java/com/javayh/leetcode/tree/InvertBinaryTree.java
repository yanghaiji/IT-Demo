package com.javayh.leetcode.tree;

/**
 * <p>
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-26
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        /*
         * 翻转一棵二叉树。
         *
         * 输入：

                     4
                   /   \
                  2     7
                 / \   / \
                1   3 6   9
          输出：

                     4
                   /   \
                  7     2
                 / \   / \
                9   6 3   1

                链接：https://leetcode-cn.com/problems/invert-binary-tree
         */
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        if (root.left == null && root.right == null){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
