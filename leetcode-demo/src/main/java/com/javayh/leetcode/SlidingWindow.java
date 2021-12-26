package com.javayh.leetcode;

/**
 * <p>
 * 滑动窗口算法
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.leetcode → 滑动窗口算法
 * @since 2022-01-01
 */
public class SlidingWindow {

    public static void main(String[] args) {

        System.out.println(findMaxAve(new int[]{1, 346, 782, 6, -77, 90,}, 4));
        System.out.println(findMaxAve(new int[]{1, 2, 3, 4, 5, 6,}, 4));

    }

    private static double findMaxAve(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        //第一个窗口 确定第一个窗口的数据和
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = k; i < n; i++) {
            // 减去原窗口的第一数据，增加新窗口的第一个数据
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(sum, max);
        }
        return 1.0 * max / k;
    }


}
