package com.cll.mix.algorithm;

import java.util.Arrays;

/**
 * @ClassName CanThreePartsEqualSum
 * @Description
 *
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * //
 * // 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... +
 * // A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * // 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * //输出：true
 * //解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * //
 * //
 * // 示例 2：
 * //
 * // 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * //输出：false
 * //
 * //
 * // 示例 3：
 * //
 * // 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * //输出：true
 * //解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 3 <= A.length <= 50000
 * // -10^4 <= A[i] <= 10^4
 *
 * @Author cll
 * @Date 2020/3/11 2:29 下午
 * @Version 1.0
 **/
public class CanThreePartsEqualSum {

    public static void main(String[] args) {
        // int[] A = {0,2,1,-6,6,-7,9,1,2,0,1};
        int[] A = {0,2,1,-6,6,7,9,-1,2,0,1};
        System.out.println(canThreePartsEqualSum(A));
    }

    /*
     *
     */
    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int a : A) {
            sum += a;
        }

        // 提前判断 如果余数不为0 则直接返回false
        if (sum % 3 != 0) {
            return false;
        }

        int part = 0, average = sum / 3, cnt = 0;
        for (int a : A) {
            part += a;
            if (part == average) {
                ++cnt;
                part = 0;
            }

        }
        return cnt >= 3 && sum % 3 == 0;
    }

}
