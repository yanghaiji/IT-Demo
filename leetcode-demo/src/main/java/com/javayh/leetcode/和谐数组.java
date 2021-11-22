package com.javayh.leetcode;

import java.util.Arrays;

/**
 * <p>
 * https://leetcode-cn.com/problems/longest-harmonious-subsequence/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-11-20
 */
public class 和谐数组 {

    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }

    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int begin = 0,res = 0;
        for(int end = 0;end < nums.length;end++){
            while(nums[end] - nums[begin] > 1) {
                begin++;
            }
            if(nums[end] - nums[begin] == 1) {
                res = Math.max(res, end - begin + 1);
            }
        }
        return res;

    }
}
