package com.java.spel.template;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-14
 */
public class TemplateSpElDemo {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        // 默认的
        String randomPhrase = parser.parseExpression(
                "random number is #{T(java.lang.Math).random()}",
                new TemplateParserContext()).getValue(String.class);
        System.out.println(randomPhrase);

        // 自定义上下文格式
        //创建解析器
        SpelExpressionParser parser3 = new SpelExpressionParser();
        //创建解析器上下文
        ParserContext context3 = new TemplateParserContext("%{", "}");
        Expression expression3 = parser3.parseExpression("你好:%{#name},我们正在学习:%{#lesson}", context3);
        //创建表达式计算上下文
        EvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("name", "路人甲java");
        evaluationContext.setVariable("lesson", "spring高手系列!");
        //获取值
        String value3 = expression3.getValue(evaluationContext, String.class);
        System.out.println(value3);


        // 不同模板的定义
        String str = "今天的日期是 #{ demo }";
        Expression expression = parser.parseExpression(str,ParserContext.TEMPLATE_EXPRESSION);
        TempEventContext tempEventContext = new TempEventContext();
        tempEventContext.setDemo(DateFormatUtils.format(new Date(),"yyyy-MM-d"));
        String value = expression.getValue(tempEventContext, String.class);

        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("demo",DateFormatUtils.format(new Date(),"yyyy-MM-d"));
        String str2 = "今天的日期是 #{ #demo }";
        Expression expression2 = parser.parseExpression(str2,ParserContext.TEMPLATE_EXPRESSION);
        String value2 = expression2.getValue(context, String.class);

        System.out.println(value2);
        System.out.println(value);

    }
}
