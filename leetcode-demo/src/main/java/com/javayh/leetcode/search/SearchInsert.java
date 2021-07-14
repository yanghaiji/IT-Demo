package com.javayh.leetcode.search;

/**
 * <p>
 * https://leetcode-cn.com/problems/search-insert-position/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-23
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        SearchInsert insert = new SearchInsert();
        System.out.println(insert.searchInsert(nums, 5));
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * 示例 1:
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * <p>
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        //两种特殊情况
        if(nums[start] >= target){
            return start;
        }
        if(nums[end-1] == target){
            return end-1;
        }
        while (start < end) {
            // 对半查询
            int mid = (start + end) / 2;
            // 目标数大于 mid
            if(nums[mid] < target){
                // 扩大起始位置
                start = mid + 1;
            }
            // nums[mid] > =
            else{
                // 缩小结束位置
                end = mid;
            }
        }
        return start;
    }


    /**
     * 暴力破解的方式，这只适合数据量较少的时候
     */
    public int searchInsertB(int[] nums, int target) {
        int index = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= target) {
                index = i;
                break;
            }
        }
        return index;
    }
}
