package com.javayh.patter.tempalte;

/**
 * <p>
 * 模板模式
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-04-25
 */
public class TemplatePatternTest {
    public static void main(String[] args) {
        TomcatTemplate tomcat = new TomcatRun();
        tomcat.run(8080,200,"/api/");
    }
}
