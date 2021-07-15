package com.javayh.leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * <p>
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-08
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack< Integer > stack = new Stack < > ();
        HashMap< Integer, Integer > map = new HashMap < > ();
        int[] res = new int[nums1.length];
        for (int value : nums2) {
            while (!stack.empty() && value > stack.peek()) {
                map.put(stack.pop(), value);
            }
            stack.push(value);
        }
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};
        NextGreaterElement element = new NextGreaterElement();
        System.out.println(Arrays.toString(element.nextGreaterElement(nums1, nums2)));
    }
}
