package com.javayh.leetcode.divideconquer;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-12
 */
public class Test {
    public static void main(String[] args) {
        test(4);
    }

    static void test(int num){
        System.out.println("num " + num);
        if(num > 0){
            test(--num);
            System.out.println("num减减 " + num);
        }
        System.out.println("num end");
    }
}
