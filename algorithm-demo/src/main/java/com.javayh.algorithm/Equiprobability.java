package com.javayh.algorithm;

/**
 * <p>
 * 等概率返回
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @className advanced-demo → com.javayh.algorithm → Equiprobability
 * @since 2022-06-21
 */
public class Equiprobability {

    public static void main(String[] args) {
        //等概率返沪 1-7
        int[] count = new int[8];
        int sum = 100000;
        for (int i = 0; i < sum; i++) {
            int a = go();
            count[a]++;
        }

        for (int i = 0; i < 8; i++) {
            System.out.println(i + "出现的次数" + count[i]);
        }

    }

    /**
     * 随机返回 1~5
     *
     * @return
     */
    public static int ans() {
        return (int) (Math.random() * 5 + 1);
    }

    /**
     * 等概率返回 0 1
     *
     * @return
     */
    public static int ans2() {
        int ans;
        // 等概率返回 1 2 4 5
        do {
            ans = ans();
            // 如果返回3将重置
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /**
     * 等概率返回 000 111 也就做到了 0 ~ 7等概率返回
     *
     * @return
     */
    public static int ans3() {
        return (ans2() << 2) + (ans2() << 1) + ans2();
    }

    /**
     * 等概率返回0-6
     *
     * @return
     */
    public static int ans4() {
        int ans;
        do {
            ans = ans3();
            // 如果返回7将重置
        } while (ans == 7);
        return ans;
    }

    public static int go() {
        return ans4() + 1;
    }
}
