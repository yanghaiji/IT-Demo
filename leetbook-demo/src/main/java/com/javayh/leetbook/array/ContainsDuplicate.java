package com.javayh.leetbook.array;

import java.util.HashSet;

/**
 * <p>
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.leetbook.array → ContainsDuplicate
 * @since 2022-02-10
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    public static boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer i : nums) {
            hashSet.add(i);
        }
        return length != hashSet.size();
    }
}
