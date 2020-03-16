package com.cll.mix.algorithm;

/**
 * @ClassName CompressString
 * @Description
 *
 * //字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没
 * //有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * //
 * // 示例1:
 * //
 * //
 * // 输入："aabcccccaaa"
 * // 输出："a2b1c5a3"
 * //
 * //
 * // 示例2:
 * //
 * //
 * // 输入："abbccd"
 * // 输出："abbccd"
 * // 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * //
 * //
 * // 提示：
 * //
 * //
 * // 字符串长度在[0, 50000]范围内。
 *
 *
 * @Author cll
 * @Date 2020/3/16 2:03 下午
 * @Version 1.0
 **/
public class CompressString {

    public static void main(String[] args) {
        String S = "aa";
        System.out.println(compressString(S));
    }

    public static String compressString(String S) {
        int srcLen = S.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char[] sc = S.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            int index = i;
            for (int j = i+1; j < sc.length; j++) {
                if (sc[i] != sc[j]) {
                    break;
                }
                count++;
            }
            sb.append(sc[i]).append(count);
            i += (count-1);
            count = 1;
        }

        return sb.toString().length() >= srcLen ? S : sb.toString();
    }

}
