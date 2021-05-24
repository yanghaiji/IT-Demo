package com.javayh.patter.factory;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-04-26
 */
public class FactoryTest {
    public static void main(String[] args) {
        AbstractFactory factory = new FactoryImpl();
        factory.create("A");
    }
}
