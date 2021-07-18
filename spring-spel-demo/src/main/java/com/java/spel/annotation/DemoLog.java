package com.java.spel.annotation;

import java.lang.annotation.*;

/**
 * <p>
 *
 * </p>
 * @author haiyang
 * @version 1.0.0
 * @since 2021/7/16
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DemoLog {

    String name() default "demo";

    String el();
}
