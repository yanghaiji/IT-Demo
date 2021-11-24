package com.javayh.leetcode;

/**
 * <p>
 * https://leetcode-cn.com/problems/buddy-strings/
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-11-23
 */
public class _859_亲密字符串 {
    public static void main(String[] args) {

        String s = "ab", goal = "ab";
        System.out.println(buddyStrings(s, goal));
    }

    public static boolean buddyStrings(String s, String goal) {
        int n = s.length(), m = goal.length();
        if (n != m) {
            return false;
        }
        // 初始化 26 个英文字母的长度 ,默认都是0
        int[] cnt1 = new int[26], cnt2 = new int[26];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // 获取相同下标下的元素，减去相同的元素，
            // 结果一样，代表两个数组相同下标的元素一样
            // 反之亦然
            int a = s.charAt(i) - 'a', b = goal.charAt(i) - 'a';
            // 将得到的差数，放在相应的位置
            cnt1[a]++;
            cnt2[b]++;
            // 如果不相等 ，表示加一
            if (a != b) {
                sum++;
            }
        }
        boolean ok = false;
        for (int i = 0; i < 26; i++) {
            // 上面的操作已经将计算后的结果放在响应的下标下，只要相同下标下的数据不同，则不是亲密字符串
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
            // 初始化 为0，而计算的不一定填满 26个位置, 而如果所有位置上的数都为1，说明肯定是相同的字符串，则不是亲密字符串，反之亦然
            if (cnt1[i] > 1) {
                ok = true;
            }
        }
        return sum == 2 || (sum == 0 && ok);
    }
}
