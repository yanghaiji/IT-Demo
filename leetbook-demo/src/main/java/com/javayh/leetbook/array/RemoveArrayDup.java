package com.javayh.leetbook.array;

/**
 * <p>
 * 删除重复数据的元素,数组为有序的
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.leetbook.array → RemoveArrayDup
 * @since 2022-02-10
 */
public class RemoveArrayDup {

    public static void main(String[] args) {
        int[] ints = {2, 2, 5, 6, 7, 8, 8, 9};
        System.out.println(removeDuplicates(ints));
    }

    /**
     * <p>
     * 采用双指针算法
     * </p>
     *
     * @param nums
     * @return int
     * @version 1.0.0
     * @author hai ji
     * @since 2022/2/10
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
