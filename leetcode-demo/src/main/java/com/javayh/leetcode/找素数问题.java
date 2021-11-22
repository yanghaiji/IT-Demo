package com.javayh.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-11-21
 */
public class 找素数问题 {
    public static void main(String[] args) {
        System.out.println(bf(100));
    }

    // 求 数字n 以内的素数
    public static int bf(int n) {
        int bf = 0;
        if (n == 0 || n == 1) {
            return bf;
        }
        for (int i = 2; i < n; i++) {
            bf += isPrime(i) ? 1 : 0;

        }
        return bf;
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    // 艾塞法
    public static int eratosthenes(int n) {
        // false 代表素数
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime(i)) {
                count++;
                // j 代表合数的标记为
                // 两个素数相乘的数
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }
}
