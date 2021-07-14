package com.javayh.algorithm;

/**
 * <p>
 * 递归的演示
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-26
 */
public class RecursiveCase {
    public static void main(String[] args) {
        System.out.println(recursive(99));
        int[] ints = new int[]{1,2,3,4,5};
        System.out.println(recursiveSum(ints, ints.length));
    }

    /***
     * 递归的调用过程类其实就是压栈与出栈操作 stack
     *
     * 通过代码也可以测试出来，我们将下面的 【nums++】 注释掉就会报: StackOverflowError
     *
     *  总结：
     *      递归指的是调用自己的函数。
     *      每个递归函数都有两个条件：基线条件和递归条件。
     *          - 递归条件指的是函数调用自己，而基线条件则指的是函数不再调用自己，从而避免形成无限循环。
     *      栈有两种操作：压入和弹出。
     *      所有函数调用都进入调用栈。
     *      调用栈可能很长，这将占用大量的内存。
     *
     *  {99}
     *  入参的顺数
     *          {100}
     *          {101}
     *
     *  递归回调后出栈
     *              {101}
     *              {100}
     * @param nums
     * @return
     */
    static int recursive(int nums) {
        if(nums > 100){
            return nums;
        }
        nums ++;
        return nums + recursive(nums);
    }

    static int recursiveSum(int[] ints ,int length){
        if(length ==1){
            return ints[0];
        }else {
            return recursiveSum(ints, length - 1) + ints[length-1];
        }
    }
}
