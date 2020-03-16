package com.cll.mix.algorithm;

/**
 * @ClassName MajorityElement
 * @Description
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * //
 * // 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * //
 * // 示例 1:
 * //
 * // 输入: [3,2,3]
 * //输出: 3
 * //
 * // 示例 2:
 * //
 * // 输入: [2,2,1,1,1,2,2]
 * //输出: 2
 *
 * @Author cll
 * @Date 2020/3/13 3:47 下午
 * @Version 1.0
 **/
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {1,5,5,5,5,6,7};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int count=0, ret = 0;
        for (int num: nums) {
            if (count==0) {
                ret = num;
            }
            if (num!=ret) {
                count--;
            } else {
                count++;
            }
        }
        return ret;
    }

}
