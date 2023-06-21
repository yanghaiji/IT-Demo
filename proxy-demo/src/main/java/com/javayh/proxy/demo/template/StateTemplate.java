package com.javayh.proxy.demo.template;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-06-21
 */
public interface StateTemplate {

    void doGet();

    void doPost();

    default void run() {
        doGet();
        doPost();
    }
}
