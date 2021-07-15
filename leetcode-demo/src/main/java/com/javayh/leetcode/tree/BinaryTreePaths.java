package com.javayh.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-08
 */
public class BinaryTreePaths {
    public static void main(String[] args) {

        TreeNode right = new TreeNode(3);
        TreeNode right2 = new TreeNode(5);
        TreeNode left = new TreeNode(2,null,right2);
        TreeNode root = new TreeNode(1,left,right);
        BinaryTreePaths paths = new BinaryTreePaths();
        System.out.println(paths.binaryTreePaths(root));
    }
    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     *
     * 输入:
     *
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     *
     * 输出: ["1->2->5", "1->3"]
     *
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     *
     * 链接：https://leetcode-cn.com/problems/binary-tree-paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(root.val);
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }
}
