package com.cll.mix.leetcode.array;

/**
 * 从排序数组中删除重复项
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例：
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 给定 nums = [1,1,1,2,2,2,1,1,1,2,3,1,2],
 * 函数应该返回新的长度 7, 并且原数组 nums 的前五个元素被修改为 1,2,1,2,3,1,2,1,1,2,3,1,2。
 *
 * create on 2019-06-09 22:40:00
 */
public class DeleteRepeatElement {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,1,1,1,2,3,1,2};
        System.out.println(removeDuplicates(nums));
        for (int a = 0; a < nums.length; a++){
            System.out.println(nums[a]);
        }
    }

    /*
     * 具体方法
     */
    public static int removeDuplicates(int[] nums) {
        // 非0校验
        if (nums.length == 0) {
            return 0;
        }
        // 定义变量 记录不重复元素的位置
        int number = 0;

        // 遍历数组元素且进行比较
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[number]) {
                number++;
                nums[number] = nums[i];
            }
        }

        return number + 1;
    }

}
