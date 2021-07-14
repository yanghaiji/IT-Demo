package com.javayh.leetcode;

/**
 * <p>
 * https://leetcode-cn.com/problems/power-of-four/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-05-31
 */
public class PowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(4));
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(7));
        System.out.println(isPowerOfFour(-2147483648));
    }

    public static boolean isPowerOfFour(int n) {
        return (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
