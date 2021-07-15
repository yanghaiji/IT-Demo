package com.javayh.advanced.java.java.annotation;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan-haiji
 * @version 1.0.0
 * @since 2020-07-17
 */
public class AddMapper {

    @Limit(value = "Test")
    public void test() {
        System.out.println("test case");
    }

    public void additional() {
        System.out.println("additional test case");
    }

    private void add() {
        System.out.println("add test case");
    }

}
