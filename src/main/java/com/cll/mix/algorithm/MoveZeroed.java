package com.cll.mix.algorithm;

/**
 * @ClassName MoveZeroed
 * @Description
 * //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * //
 * // 示例:
 * //
 * // 输入: [0,1,0,3,12]
 * //输出: [1,3,12,0,0]
 * //
 * // 说明:
 * //
 * //
 * // 必须在原数组上操作，不能拷贝额外的数组。
 * // 尽量减少操作次数。
 * //
 * // Related Topics 数组 双指针
 * @Author cll
 * @Date 2020/2/26 3:46 下午
 * @Version 1.0
 **/
public class MoveZeroed {

    public static void main(String[] args) {
        // TODO 必须在原数组上操作，不能拷贝额外的数组。
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        // 遍历 当前元素前0元素存在的次数  a
        int zeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                zeroes ++;
            }else{
                nums[i-zeroes] = nums[i];
            }
        }

        for (int i = nums.length -zeroes ; i < nums.length; i++) {
            nums[i] = 0;
        }

        for (int num : nums) {
            System.out.println(num);
        }

    }
}
