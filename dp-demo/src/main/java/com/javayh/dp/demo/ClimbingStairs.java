package com.javayh.dp.demo;

/**
 * <p>
 * 有一个n级的楼梯，每次只能爬1级或2级，求爬到第n级有多少种不同的方法
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-07-21
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(5));
    }

    /**
     * n = 1 , 1  >>> 1
     * n = 2 , 2  >>> 1,1;2
     * n = 3 , 3  >>> 1,1,1;2,1;1,2
     * n = 4 , 5  >>> 1,1,1,1;1,1,2;1,2,1;2,1,1;2,2
     * n = 5 , 8
     * <p>
     * n = n , (n-1) + (n -2)
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }

}
