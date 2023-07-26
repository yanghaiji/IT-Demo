package com.javayh.dp.demo;

import java.util.Arrays;

/**
 * <p>
 * 给定一个整数数组nums，找到其中最长严格递增子序列的长度
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-07-21
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18, 38};
        System.out.println(lis.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        /*
         * 拿到当前的元素，与之前所有的元素做对比
         * 在内层循环中，我们检查nums[i]是否大于nums[j]，如果满足这个条件，
         * 说明我们可以将nums[i]添加到以nums[j]结尾的递增子序列中，
         * 从而得到一个以nums[i]结尾的更长的递增子序列。因此，我们更新dp[i]为dp[j] + 1，表示以nums[i]结尾的最长递增子序列的长度。
         *  i = 1 ,nums[i] = 9 nums[j] =10
         *如果nums[i] > nums[j]，那么nums[i]可以扩展以nums[j]结尾的递增子序列。因此，我们可以更新dp[i]为dp[j] + 1，
         * 表示以nums[i]结尾的最长递增子序列的长度。同时，我们要确保在所有满足条件的nums[i]中选择最大的长度。
         * 对于示例数组[10, 9, 2, 5, 3, 7, 101, 18,38]，填充后的dp数组为：[1, 1, 1, 2, 2, 3, 4, 4,5]
         * 之后去里边最大值即可
         */
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
