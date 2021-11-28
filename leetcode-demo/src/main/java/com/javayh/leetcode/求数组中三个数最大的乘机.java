package com.javayh.leetcode;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-11-27
 */
public class 求数组中三个数最大的乘机 {

    public static void main(String[] args) {
        int[] nums = {-8,-5,3,5,6,7};
        System.out.println(sort(nums));
        System.out.println(getMax(nums));
    }

    /**
     * 通过排序算出最大最小值
     * 数组中可能有正数有负数，分为两种情况
     * 1. 两负一整
     * 2.三正
     */
    public static int sort(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(nums[0] * nums[1] * nums[length - 1], nums[length - 1] * nums[length - 2] * nums[length - 3]);
    }

    /**
     * 通过线程查找，省区排序时间
     */
    public static int getMax(int[] nums) {
        //定义两个最小值
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        //定义三个最大的值
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            } else if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
