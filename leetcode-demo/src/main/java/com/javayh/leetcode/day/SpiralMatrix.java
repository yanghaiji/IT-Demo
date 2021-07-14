package com.javayh.leetcode.day;

import java.util.Arrays;

/**
 * <p>
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-16
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        /**
         * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
         * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
         * https://leetcode-cn.com/problems/spiral-matrix-ii/
         */
        int[][] ints = SpiralMatrix.generateMatrix(1);
    }

    public static int[][] generateMatrix(int n) {
        if(1 == n){
            return new int[][]{{1}};
        }
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++){
                mat[t][i] = num++; // left to right.
            }
            t++;
            for(int i = t; i <= b; i++){
                mat[i][r] = num++; // top to bottom.
            }
            r--;
            for(int i = r; i >= l; i--) {
                mat[b][i] = num++; // right to left.
            }
            b--;
            for(int i = b; i >= t; i--){
                mat[i][l] = num++; // bottom to top.
            }
            l++;
        }
        return mat;
    }
}
