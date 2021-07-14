package com.javayh.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     链接：https://leetcode-cn.com/problems/contiguous-array/solution/lian-xu-shu-zu-by-leetcode-solution-mvnm/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-06-03
 */
public class lianXushuzubyleetcodesolutionmvnm {
    public static void main(String[] args) {
        int[] nums = {0,1,0,1};
        System.out.println(new Solution().findMaxLength(nums));
    }
    static class Solution {
        // 0,1,0,1
        public int findMaxLength(int[] nums) {
            int maxLength = 0;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int counter = 0;
            map.put(counter, -1);
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                if (num == 1) {
                    counter++;
                } else {
                    counter--;
                }
                if (map.containsKey(counter)) {
                    int prevIndex = map.get(counter);
                    maxLength = Math.max(maxLength, i - prevIndex);
                } else {
                    map.put(counter, i);
                }
            }
            return maxLength;
        }
    }

}
