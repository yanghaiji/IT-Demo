package com.javayh.leetcode;

/**
 * <p>
 * 有一个小商贩，水果为5块一个，
 * 现在开始卖水果，会有三种付钱的方式，5，10，20，
 * 求排队买水过的人，付完钱后是否可以进行找零
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.leetcode → LemoChange
 * @since 2022-01-04
 */
public class LemonChange {
    public static void main(String[] args) {

        int[] lemon = new int[]{5, 5, 10, 20};
        int[] lemon2 = new int[]{5, 5, 10, 20, 20};
        int[] lemon3 = new int[]{5, 20};
        System.out.println(change(lemon));
        System.out.println(change(lemon2));
        System.out.println(change(lemon3));
    }

    private static boolean change(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
