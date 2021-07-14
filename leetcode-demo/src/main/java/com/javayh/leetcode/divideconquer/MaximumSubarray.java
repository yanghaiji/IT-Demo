package com.javayh.leetcode.divideconquer;

/**
 * <p>
 * https://leetcode-cn.com/problems/maximum-subarray/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-26
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        /**
         * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
         *
         * 示例 1：
         * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
         * 输出：6
         * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
         * 示例 2：
         * 输入：nums = [1]
         * 输出：1
         * 链接：https://leetcode-cn.com/problems/maximum-subarray
         */
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(nums));
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
