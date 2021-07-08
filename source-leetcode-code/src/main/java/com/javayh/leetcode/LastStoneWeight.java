package com.javayh.leetcode;

import java.util.Random;

/**
 * <p>
 * https://leetcode-cn.com/problems/last-stone-weight-ii/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-06-08
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(30);
        System.out.println(i);
    }

    public int lastStoneWeightII(int[] stones) {
        if(stones.length == 1){
            return stones[0];
        }


        return 0;
    }
}
