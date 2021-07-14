package com.javayh.leetcode.number;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * https://leetcode-cn.com/problems/single-number/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-10
 */
public class SingleNumber {
    public static void main(String[] args) {
        /**
         * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
         * 说明：
         * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
         *
         * 示例 1:
         * 输入: [2,2,1]
         * 输出: 1
         *
         * 示例 2:
         *
         * 输入: [4,1,2,1,2]
         * 输出: 4
         *
         * 链接：https://leetcode-cn.com/problems/single-number
         */
        int[] nums = {2,-4,1,1,2};
        int single = 0;
        for (int num : nums) {
            single ^= num;
            System.out.println(single);
        }
        System.out.println("-----");
        Map<Integer,Integer> sum = new HashMap<>();
        for (int num : nums) {
            if (sum.containsKey(num)) {
                //sum.put(num,sum.get(num)+1);
                sum.remove(num);
            }
            else {
                sum.put(num,1);
            }
        }
        Object[] objects = sum.entrySet().toArray();
        String s = String.valueOf(objects[0]);
        System.out.println(Integer.parseInt(s.substring(0, s.indexOf("="))));

        //return objects[0].toString().substring(0,1);
    }
}
