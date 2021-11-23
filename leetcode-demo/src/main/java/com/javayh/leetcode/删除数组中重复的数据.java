package com.javayh.leetcode;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-11-22
 */
public class 删除数组中重复的数据 {
    public static void main(String[] args) {
        // 双指针算法
        System.out.println(remove(new int[]{0, 1, 2, 2, 2, 3, 3, 4, 5}));
    }


    public static int remove(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                // 不相等时原数据并没有发生变话
                nums[j] = nums[i];
            }
            System.out.println(Arrays.toString(nums));
        }
        System.out.println(Arrays.toString(nums));
        return j + 1;
    }
}
