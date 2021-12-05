package com.javayh.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-12-05
 */
public class 两数之和 {
    /**
     * 给定有序数组求，以及目标元素，求在数组里两数和等于目标元素的两数下标
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution01(new int[]{1, 2, 4, 5, 6, 7, 11}, 10)));
        System.out.println(Arrays.toString(solution02(new int[]{1, 2, 4, 5, 6, 7, 11}, 10)));
    }

    /**
     * 暴力算法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution01(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //这里至于要大于上层循环的下标，减少循环的次数
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static int[] solution02(int[] nums, int target) {
        Map<Integer, Integer> map_cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map_cache.containsKey(target - nums[i])) {
                return new int[]{i, map_cache.get(target - nums[i])};
            }
            map_cache.put(nums[i], i);
        }
        return new int[0];
    }

}

