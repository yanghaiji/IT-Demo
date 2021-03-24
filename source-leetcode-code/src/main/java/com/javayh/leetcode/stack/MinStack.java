package com.javayh.leetcode.stack;

import java.util.Stack;

/**
 * <p>
 *  https://leetcode-cn.com/problems/min-stack/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-08
 */
public class MinStack {

    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * push(x) —— 将元素 x 推入栈中。
     * pop() —— 删除栈顶的元素。
     * top() —— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     *
     * 链接：https://leetcode-cn.com/problems/min-stack
     */

    private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public void pop() {
        // 如果删除的时栈内的最小值，需要重置 min 的值，否则将一直时原来未删除栈的值
        if(stack.pop() == min){
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        stack.forEach(s->{
            min = Math.min(s,min);
        });
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.top();
        System.out.println(minStack.getMin());

    }
}
