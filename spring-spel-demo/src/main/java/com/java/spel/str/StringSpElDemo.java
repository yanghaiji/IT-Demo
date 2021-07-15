package com.java.spel.str;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-14
 */
public class StringSpElDemo {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        System.out.println(message);

        Expression exp2 = parser.parseExpression("'Hello World'.concat('!')");
        String message2 = (String) exp2.getValue();
        System.out.println(message2);

        // invokes 'getBytes()'
        Expression exp3 = parser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[]) exp3.getValue();
        System.out.println(Arrays.toString(bytes));

        // invokes 'getBytes().length'
        Expression exp4 = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) exp4.getValue();
        System.out.println(length);

        Expression exp5 = parser.parseExpression("new String('hello world').toUpperCase()");
        String toUpperCase = exp5.getValue(String.class);
        System.out.println(toUpperCase);
    }
}
