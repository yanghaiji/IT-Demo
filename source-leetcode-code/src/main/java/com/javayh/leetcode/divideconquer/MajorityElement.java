package com.javayh.leetcode.divideconquer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * https://leetcode-cn.com/problems/majority-element/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-01
 */
public class MajorityElement {
    public static void main(String[] args) {
        /**
         * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
         *
         * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
         * 链接：https://leetcode-cn.com/problems/majority-element
         */
        int[] nums = {3,2,3};
        MajorityElement element = new MajorityElement();
        System.out.println(element.majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> count = new HashMap<>();
        for (int num: nums) {
            if (count.containsKey(num)) {
                Integer integer = count.get(num);
                count.put(num, ++integer);
            }else {
                count.put(num, 1);
            }
        }
        int max = 0;
        int val = 0;
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            Integer value = entry.getValue();
            if(max < value){
                max = value;
                val = entry.getKey();
            }
        }
        return val;
    }
}
