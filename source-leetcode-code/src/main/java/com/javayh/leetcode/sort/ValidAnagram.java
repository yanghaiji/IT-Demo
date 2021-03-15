package com.javayh.leetcode.sort;

import java.util.Arrays;

/**
 * <p>
 * https://leetcode-cn.com/problems/valid-anagram
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-03-12
 */
public class ValidAnagram {
    public static void main(String[] args) {
        /**
         * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
         *
         * 示例 1:
         *
         * 输入: s = "anagram", t = "nagaram"
         * 输出: true
         * 示例 2:
         *
         * 输入: s = "rat", t = "car"
         * 输出: false
         * 说明:
         * 你可以假设字符串只包含小写字母。
         *
         * 链接：https://leetcode-cn.com/problems/valid-anagram
         */
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return Arrays.equals(chars, chars1);
    }
}
