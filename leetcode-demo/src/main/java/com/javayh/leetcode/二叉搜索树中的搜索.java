package com.javayh.leetcode;

/**
 * <p>
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-11-26
 */
public class 二叉搜索树中的搜索 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //这个题没什么多说点，肯定是递归，但是不要大意，不能判断是否相等，
    //而是根据左侧小于右侧的原则进行查询
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public static void main(String[] args) {
        //[4,2,7,1,3]
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode7 = new TreeNode(7,treeNode3,null);
        TreeNode treeNode2 = new TreeNode(2,treeNode1,null);
        TreeNode treeNode4 = new TreeNode(4,treeNode2,treeNode7);
        System.out.println(searchBST(treeNode4, 1));
    }
}
