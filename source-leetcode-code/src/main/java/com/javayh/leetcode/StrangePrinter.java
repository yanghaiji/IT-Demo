package com.javayh.leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * https://leetcode-cn.com/problems/strange-printer/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-05-24
 */
public class StrangePrinter {
    public static void main(String[] args) {
        String s = "abcabc";
        String s2 = "aaabbb";
        System.out.println(strangePrinter(s));
        System.out.println(strangePrinter(s2));
    }

    public static int strangePrinter(String s) {
        AtomicInteger print = new AtomicInteger(1);
        //初始化的数据
        List<Byte> list = new LinkedList<>();
        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            list.add(bytes[0]);
        }
        for (int i = 1; i < bytes.length; i++) {
            if (bytes[i] == list.get(i) || bytes[i-1] == list.get(i)) {
                continue;
            } else {
                for (int j = i; j < bytes.length; j++) {
                    list.set(j,bytes[i]);
                }
                print.incrementAndGet();
            }
        }
        return print.get();
    }

}
