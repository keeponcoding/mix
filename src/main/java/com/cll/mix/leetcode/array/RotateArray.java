package com.cll.mix.leetcode.array;

/**
 * @ClassName RotateArray
 * @Description 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * @Author cll
 * @Date 2019-07-18 16:27
 * @Version 1.0
 **/
public class RotateArray {

    public static void main(String[] args) {
        int[] numArr = {1,2,3,4,5,6,7};// 带旋转数组
        int step = 3;// 旋转步数
        rotateArray(numArr,step);
        for (int i = 0; i < numArr.length; i++) {
            System.out.println(numArr[i]);
        }
    }

    private static void rotateArray(int[] numArr,int step) {
        if(numArr.length == 0){
            return;
        }


    }

}
