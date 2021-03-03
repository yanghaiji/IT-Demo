package com.javayh.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 原子
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-02
 */
public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.incrementAndGet();
        atomicInteger.decrementAndGet();
    }
}
