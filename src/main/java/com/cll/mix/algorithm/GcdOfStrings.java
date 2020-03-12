package com.cll.mix.algorithm;

/**
 * @ClassName GcdOfStrings
 * @Description
 *
 * //对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * //
 * // 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * // 输入：str1 = "ABCABC", str2 = "ABC"
 * //输出："ABC"
 * //
 * //
 * // 示例 2：
 * //
 * // 输入：str1 = "ABABAB", str2 = "ABAB"
 * //输出："AB"
 * //
 * //
 * // 示例 3：
 * //
 * // 输入：str1 = "LEET", str2 = "CODE"
 * //输出：""
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= str1.length <= 1000
 * // 1 <= str2.length <= 1000
 * // str1[i] 和 str2[i] 为大写英文字母
 *
 * @Author cll
 * @Date 2020/3/12 2:00 下午
 * @Version 1.0
 **/
public class GcdOfStrings {

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
    }

    /*
     * 执行时间比较长 性能比较差 26ms
     */
    public static String gcdOfStrings(String str1, String str2){
        int len1 = str1.length(), len2 = str2.length();
        String s = len1 > len2 ? str2 : str1;
        int max = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (len1 % i != 0 || len2 % i != 0) {
                continue;
            }
            String sub = s.substring(0, i);
            if (str1.replaceAll(sub, "").isEmpty() && str2.replaceAll(sub, "").isEmpty()) {
                max = i;
            }
        }
        return s.substring(0, max);
    }

    /*
     * 1ms
     */
    public static String gcdOfStrings2(String str1, String str2){
        int m = str1.length(), n = str2.length(), d = gcd(m, n);
        String s = str1.substring(0, d), str = str1 + str2;
        for (int i = 0; i < m + n; i += d) {
        if (!str.startsWith(s, i))
            return "";
        }
        return s;
    }

    private static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

}
