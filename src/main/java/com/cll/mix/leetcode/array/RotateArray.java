package com.cll.mix.leetcode.array;

import java.sql.SQLOutput;

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
        int[] numArr = {1,2,3,4,5,6};// 待旋转数组

        int step = 2;// 旋转步数
        //System.out.println(7 % 2);
        rotateArray2(numArr,step);
        for (int i = 0; i < numArr.length; i++) {
            System.out.println(numArr[i]);
        }
    }

    /**
     * 示例：
     * 1,2,3,4,5,6,7   3
     *   1. 7,1,2,3,4,5,6
     *   2. 6,7,1,2,3,4,5
     *   3. 5,6,7,1,2,3,4
     * 相当于把 5,6,7 调换了个位置 1,2,3,4,
     * @param numArr
     * @param step
     */
    // TODO 待完善 此方法不适用
    private static void rotateArray(int[] numArr, int step) {
        int len = numArr.length;
        if(len == 0){
            return;
        }
        // 将旋转步数重新赋值 防止多余旋转
        step = step % len;
        if(step != 0){
            // 需要旋转的起始位置
            int startIdx = len-step;
            /*
             * 1 2 3 4 5 6 7
             * 0 1 2 3 4 5 6
             *
             * 1 2 3 4 5 6 7
             * 3 4 5 6 0 1 2
             */
            int temp1,temp2 = 0;

            temp1 = numArr[(startIdx+step)%len];        // numArr[0]
            numArr[(startIdx+step)%len] = numArr[startIdx];

            /*
            分析过程如下：

            temp2 = numArr[(startIdx+step*2)%len]; // numArr[3]
            numArr[(startIdx+step*2)%len] = temp1;

            temp1 = numArr[(startIdx+step*3)%len]; // numArr[6]
            numArr[(startIdx+step*3)%len] = temp2;

            temp2 = numArr[(startIdx+step*4)%len]; // numArr[2]
            numArr[(startIdx+step*4)%len] = temp1;

            temp1 = numArr[(startIdx+step*5)%len]; // numArr[5]
            numArr[(startIdx+step*5)%len] = temp2;

            temp2 = numArr[(startIdx+step*6)%len]; // numArr[1]
            numArr[(startIdx+step*6)%len] = temp1;

            temp1 = numArr[(startIdx+step*7)%len]; // numArr[4]
            numArr[(startIdx+step*7)%len] = temp2;*/

            for (int i = 2; i < len+1; i++) {
                if (i%2 != 0){ // 奇数
                    temp1 = numArr[(startIdx+step*i)%len];
                    numArr[(startIdx+step*i)%len] = temp2;
                }else{ //偶数
                    temp2 = numArr[(startIdx+step*i)%len];
                    numArr[(startIdx+step*i)%len] = temp1;
                }
            }
        }

    }

    /**
     * 参考其他
     * @param nums
     * @param k
     */
    private static void rotateArray2(int[] nums, int k) {
        k = k%nums.length;
        int index = 0;
        for(int i = nums.length-k;i<nums.length;i++){//需要翻转的元素
            int t = nums[i];
            for(int j = i;j>index;j--){//为元素腾出空间
                nums[j] = nums[j-1];
            }
            nums[index++] = t;
        }
    }

    /**
     * 效率极低
     * 逐个移动 且 逐步旋转
     * @param numArr
     * @param step
     */
    private static void rotateArray1(int[] numArr,int step) {
        if(numArr.length == 0){
            return;
        }
        
        int len = numArr.length;
        int temp = 0;
        for (int i = step; i > 0; i--) {
            // 数组中最后一个元素
            temp = numArr[len-1];

            for (int j = 1; j <= len; j++) {
                if((len-j) == 0){
                    numArr[0] = temp;
                }else{
                    numArr[len-j] = numArr[len-(j+1)];
                }
            }
        }

    }

}
