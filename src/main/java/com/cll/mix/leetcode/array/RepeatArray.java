package com.cll.mix.leetcode.array;

/**
 * @ClassName RepeatArray
 * @Description 数组存在重复元素
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @Author cll
 * @Date 2019-07-24 23:40
 * @Version 1.0
 **/
public class RepeatArray {

    public static void main(String[] args) {
        int nums[] = {1,2,3,5,9};
        System.out.println(repeatArray(nums));
    }

    /**
     * 全遍历
     * @param nums
     * @return
     */
    private static boolean repeatArray(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

}
