package com.java.spel.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-07-12
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut(value = "@annotation(DemoLog)")
    public void logAspect() {

    }

    /**
     * 环绕处理
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Around(value = "logAspect()")
    public Object getAroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed;
        try {
            //前置处理
            saveLogAspect(joinPoint, null);
            proceed = joinPoint.proceed();
            return proceed;
        } catch (Throwable throwable) {
            saveLogAspect(joinPoint, throwable);
            throw new RuntimeException(throwable.getMessage());
        }
    }


    /**
     * <p>
     * profile log 全局处理
     * </p>
     *
     * @param joinPoint
     * @param throwable
     * @return void
     * @version 1.0.0
     * @since 2021/7/12
     */
    private void saveLogAspect(JoinPoint joinPoint, Throwable throwable) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        try {
            // 获取自定义注解
            DemoLog demoLog = methodSignature.getMethod().getAnnotation(DemoLog.class);
            if (Objects.nonNull(demoLog)) {
                Object spEl = AspectExpress.getSpEl(joinPoint, methodSignature, demoLog.el(), Object.class);
                if (log.isInfoEnabled()) {
                    log.info(" Demo SpEl 测试 : {}", spEl);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
