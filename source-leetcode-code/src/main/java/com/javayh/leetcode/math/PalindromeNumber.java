package com.javayh.leetcode.math;

/**
 * <p>
 *      来源：https://leetcode-cn.com/problems/palindrome-number/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-23
 */
public class PalindromeNumber {

    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     */
    public boolean isPalindrome(int x) {
        /**
         * 解题思路：
         *
         */
        if (x < 0){
            return false;
        }else {
            int temp = x;
            int n = 0;
            while (x !=0){
                n = n*10 + x%10;
                x = x/10;
            }
            return temp == n;
        }
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(-121));
    }

}
