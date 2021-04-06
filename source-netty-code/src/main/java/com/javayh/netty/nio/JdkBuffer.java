package com.javayh.netty.nio;


import java.nio.IntBuffer;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-29
 */
public class JdkBuffer {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);
        for (int i = 0; i < 10; i++) {
            buffer.put(i);
        }
        buffer.flip();

        for (int i = 0; i <10; i++) {
            System.out.println(buffer.get(i));
        }
    }
}
