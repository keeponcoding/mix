package com.cll.mix.leetcode.array;

/**
 * @ClassName SingleNumber
 * @Description
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @Author cll
 * @Date 2019-07-24 23:47
 * @Version 1.0
 **/
public class SingleNumber {

    public static void main(String[] args) {
        int nums[] = {2,2,1};
        System.out.println(singleNumber(nums));
    }

    /**
     *
     * @param nums
     */
    private static int singleNumber(int[] nums) {
        int singleNumber = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i != j & (nums[i] == nums[j])){
                    count++;
                }
            }
            if(count == 0){
                singleNumber = nums[i];
                return singleNumber;
            }
            count = 0;
        }
        return singleNumber;
    }

}
