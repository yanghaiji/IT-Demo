package com.javayh.leetcode.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * https://leetcode-cn.com/problems/scramble-string/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-04-16
 */
public class ScrambleString {

    public static void main(String[] args) {
        String s= "oefj";
    }

    public boolean isScramble(String s1, String s2) {
        List<String> sortS1 = sort(s1);
        List<String> sortS2 = sort(s2);
        sortS1.containsAll(sortS2);
        return false;
    }

    private List<String> sort(String s1){
        List<String> a = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            a.add(s1.substring(i,a.size()+1));
        }
        return a.stream().sorted().collect(Collectors.toList());
    }
}
