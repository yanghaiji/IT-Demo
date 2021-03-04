package com.javayh.leetcode.math;

/**
 * <p>
 *      来源：https://leetcode-cn.com/problems/reverse-integer/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-23
 */
public class ReverseInteger {
    /**
     * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     */
    public int reverse(int x) {
        long n = 0;
        while(x != 0) {
            /**
             * 解题思路：
             *      首先取出入参的个位数，并将过大十倍， 在将入参缩小十倍，这样可以剔除个位数
             *      反复执行即可
             *
             * x 321
             * 当第一次进入时
             *     n*10 = 0
             *     x%10 等于个位的数
             *     n = 个位的数
             *     x = 剔除个位后的数
             *  这样如此反复， n扩大 n*10 并将 x加到当前 n 的个位上
             */
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }

    public static void main(String[] args) {
        ReverseInteger integer = new ReverseInteger();
        System.out.println(integer.reverse(321));
    }
}
