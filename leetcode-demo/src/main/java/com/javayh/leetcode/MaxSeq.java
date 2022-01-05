package com.javayh.leetcode;

/**
 * <p>
 * 找出最长的递增序列
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.leetcode → MaxSeq
 * @since 2022-01-04
 */
public class MaxSeq {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 6};
        System.out.println(findMaxLength(nums));
    }

    private static int findMaxLength(int[] nums) {
        int start = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                start = i;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
