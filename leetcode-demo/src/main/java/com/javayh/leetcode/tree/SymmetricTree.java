package com.javayh.leetcode.tree;

/**
 * <p>
 * https://leetcode-cn.com/problems/symmetric-tree/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-24
 */
public class SymmetricTree {
    public static void main(String[] args) {
        //给定一个二叉树，检查它是否是镜像对称的。
        /**
         * 如何判断是否是镜像二叉树
         *                     ②
         *               ①           ①
         *           ②      ③   ③       ②
         * 这是一个镜像的二叉树
         * 首先，根节点必须相同
         * 然后就是每个树的左子树等于右子树的值 形成镜像
         * 就像我们照镜子一样，左右是跌倒的
         */

    }
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

}


