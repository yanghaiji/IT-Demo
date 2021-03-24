package com.javayh.leetcode.tree;

/**
 * <p>
 * https://leetcode-cn.com/problems/same-tree/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-24
 */
public class SameTree {
    public static void main(String[] args) {

        // 判断两个二叉树是否完全相同
        SameTree sameTree = new SameTree();

        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p = new TreeNode(1, p2, p3);

        TreeNode q2 = new TreeNode(2);
        TreeNode q3 = new TreeNode(3);
        TreeNode q = new TreeNode(1, q2, q3);

        System.out.println(sameTree.isSameTree(p, q));
    }

    /**
     * 深度优先原则，实则就是前序遍历
     * <p>
     * 首先判断root 节点是否相等
     * 然后判断两个树的左节点 和 右节点是否相同
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

}


