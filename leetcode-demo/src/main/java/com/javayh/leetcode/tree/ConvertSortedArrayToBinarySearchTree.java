package com.javayh.leetcode.tree;

/**
 * <p>
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-24
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        /**
         * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
         * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
         * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
         */
        int[] nums = {2,4,9,13,19,20,23};
        ConvertSortedArrayToBinarySearchTree tree = new ConvertSortedArrayToBinarySearchTree();
        TreeNode treeNode = tree.sortedArrayToBST(nums);
        System.out.println(treeNode);

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return  new TreeNode();
        }
        return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        System.out.println("----");
        root.right = helper(nums, mid + 1, right);
        return root;
    }

}
