package com.javayh.leetcode;

import java.util.Arrays;

/**
 * <p>
 * 求给定数组里能组成三角形的最大周长
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.leetcode → Triangles
 * @since 2022-01-12
 */
public class Triangles {

    public static void main(String[] args) {
        System.out.println(lenMax(new int[]{2, 3, 4, 6, 8, 2}));
        System.out.println(lenMax(new int[]{2, 3, 4, 6, 12}));
    }

    private static int lenMax(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; 2 <= i; i--) {
            if (nums[i - 1] + nums[i - 2] >= nums[i]) {
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }
        return 0;
    }
}
