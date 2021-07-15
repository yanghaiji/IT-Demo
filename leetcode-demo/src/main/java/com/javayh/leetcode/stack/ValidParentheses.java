package com.javayh.leetcode.stack;

import java.util.Stack;

/**
 * <p>
 * 来源：https://leetcode-cn.com/problems/valid-parentheses/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-23
 */
public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses o = new ValidParentheses();
        System.out.println(o.isValid("(()){}[{}]"));
    }

    public boolean isValid(String s) {
        //'('，')'，'{'，'}'，'['，']'
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            }
            else if (c == '[') {
                stack.push(']');
            }
            else if (c == '{') {
                stack.push('}');
            }
            else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
