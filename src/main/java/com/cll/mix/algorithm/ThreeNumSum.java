package com.cll.mix.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ThreeNumSum
 * @Description
 * //给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三
 * //元组。
 * //
 * // 注意：答案中不可以包含重复的三元组。
 * //
 * //
 * //
 * // 示例：
 * //
 * // 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * //
 * //满足要求的三元组集合为：
 * //[
 * //  [-1, 0, 1],
 * //  [-1, -1, 2]
 * //]
 * //
 * // Related Topics 数组 双指针
 * @Author cll
 * @Date 2020/2/28 4:48 下午
 * @Version 1.0
 **/
public class ThreeNumSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        for (List<Integer> list : threeSum(nums)) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<Integer>();
        for (int x = 0; x < nums.length-2; x++) {
            for (int y = x+1; y < nums.length-1; y++) {
                for (int z = y+1; z < nums.length; z++) {
                    if (nums[x] + nums[y] + nums[z] == 0) {
                        arr.add(nums[x]);
                        arr.add(nums[y]);
                        arr.add(nums[z]);
                    }
                }
            }
        }
        result.add(arr);
        return result;
    }

}
