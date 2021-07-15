package com.javayh.leetcode.math;

/**
 * <p>
 *  https://leetcode-cn.com/problems/add-binary/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-23
 */
public class AddBinary {

    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * 输入为 非空 字符串且只包含数字 1 和 0。
     * 示例 1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     *
     * 链接：https://leetcode-cn.com/problems/add-binary
     */
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.valueOf(a,2)+Integer.valueOf(b,2));
    }

    public static void main(String[] args) {
        //"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
        //"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
        //根据第二个参数转换成指定的几进制，默认十进制
        System.out.println(Integer.parseInt("10", 2));
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
    }

}
