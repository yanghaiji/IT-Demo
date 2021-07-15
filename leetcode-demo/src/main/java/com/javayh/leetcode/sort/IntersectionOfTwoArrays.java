package com.javayh.leetcode.sort;

import java.util.*;

/**
 * <p>
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-12
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        IntersectionOfTwoArrays ofTwoArrays = new IntersectionOfTwoArrays();
        System.out.println(Arrays.toString(ofTwoArrays.intersection(nums1, nums2)));
    }

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     * 示例 2：
     * <p>
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     * <p>
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums1) {
            for (int num2 : nums2) {
                if (num == num2) {
                    hashSet.add(num);
                }
            }
        }
        int[] ints = new int[hashSet.size()];
        int index = 0;
        for (int num : hashSet) {
            ints[index++] = num;
        }
        return ints;
    }

}
