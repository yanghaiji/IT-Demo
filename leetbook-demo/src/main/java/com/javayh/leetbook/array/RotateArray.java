package com.javayh.leetbook.array;

import java.util.Arrays;

/**
 * <p>
 * 旋转指定长度的数组
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.leetbook.array → RotateArray
 * @since 2022-02-10
 */
public class RotateArray {

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotate(new int[]{1, 2}, 2);
        rotate(new int[]{1, 2}, 3);
        rotate(new int[]{1}, 2);
    }

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] temps = new int[length];
        //把原数组值放到一个临时数组中，
        System.arraycopy(nums, 0, temps, 0, length);
        //然后在把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temps[i];
        }
        System.out.println(Arrays.toString(nums));
    }

//    if (nums.length >= k) {
//            int j = nums.length - k;
//            int[] temps = new int[nums.length];
//            for (int i = 0; i < k; i++) {
//                temps[i] = nums[j];
//                j++;
//            }
//            int i1 = nums.length - k;
//            for (int i = 0; i < i1; i++) {
//                temps[k] = nums[i];
//                k++;
//            }
//            System.arraycopy(temps, 0, nums, 0, temps.length);
//        }
//        System.out.println(Arrays.toString(nums));
}
