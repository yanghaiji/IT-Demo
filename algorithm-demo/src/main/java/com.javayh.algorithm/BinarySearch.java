package com.javayh.algorithm;

/**
 * <p>
 * 二分查找算法
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-25
 */
public class BinarySearch {

    public static final int SIZE = 100;

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,8,10,45,50,76};
       /* for (int i = 0; i < SIZE; i++) {
            nums[i] = i;
        }*/

        System.out.println(binarySearch(nums, 10));
    }


    /**
     * <p>
     *       查询指定数字的下标
     * </p>
     * @version 1.0.0
     * @since 2021/3/25
     * @param nums
     * @param num
     * @return int
     */
    public static int binarySearch(int[] nums,int num){
        int len = nums.length - 1;
        if(num == nums[0]){
            return 0;
        }
        if(num == nums[len]){
            return len;
        }
        int left = 0,min = 0;
        while (left <= len){
            min = (left + len) / 2;
            if(nums[min] < num){
                left = min;
                len--;
            }
            else if(nums[min] > num){
                len = min;
                left++;
            }
            else {
                return min;
            }
        }
        return -1;
    }
}
