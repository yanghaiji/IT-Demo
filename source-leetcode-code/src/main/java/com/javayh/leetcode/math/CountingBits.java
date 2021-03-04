package com.javayh.leetcode.math;

import java.util.Arrays;

/**
 * <p>
 * https://leetcode-cn.com/problems/counting-bits/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-03
 */
public class CountingBits {
    public static void main(String[] args) {
        /**
         * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
         *
         * 示例 1:
         *
         * 输入: 2
         * 输出: [0,1,1]
         *
         * 示例 2:
         *
         * 输入: 5
         * 输出: [0,1,1,2,1,2]
         *
         * 链接：https://leetcode-cn.com/problems/counting-bits
         */

        /*
            本题的意思是 给定一个数，求 0 ~ 给定数中所以数的二进制，并且计算出 二进制数中 1 出现的次数
            例如： 给定 3 求的是 0 1 2 3 的二进制
                0   0000
                1   0001
                2   0010
                3   0011
            最终结果应该返回 [0，1，1，2]
         */

        CountingBits countingBits = new CountingBits();
        System.out.println(Arrays.toString(countingBits.countBits(3)));
        System.out.println(countingBits.countOnes(3));
    }

    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }
}
