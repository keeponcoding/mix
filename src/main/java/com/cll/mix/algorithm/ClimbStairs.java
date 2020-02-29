package com.cll.mix.algorithm;

/**
 * @ClassName ClimbStairs
 * @Description
 *
 * //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * //
 * // 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * //
 * // 注意：给定 n 是一个正整数。
 * //
 * // 示例 1：
 * //
 * // 输入： 2
 * //输出： 2
 * //解释： 有两种方法可以爬到楼顶。
 * //1.  1 阶 + 1 阶
 * //2.  2 阶
 * //
 * // 示例 2：
 * //
 * // 输入： 3
 * //输出： 3
 * //解释： 有三种方法可以爬到楼顶。
 * //1.  1 阶 + 1 阶 + 1 阶
 * //2.  1 阶 + 2 阶
 * //3.  2 阶 + 1 阶
 * //
 * // Related Topics 动态规划
 *
 * @Author cll
 * @Date 2020/2/29 9:01 上午
 * @Version 1.0
 **/
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
    /*
     * 1 : 1
     * 2 : 2
     * 3 : f(1) + f(2)  到达第三个台阶只可能有两种情况 从第2个台阶跨一步  从第1个台阶跨两步
     * 4 : f(2) + f(3)  到达第四个台阶只可能有两种情况 从第3个台阶跨一步  从第2个台阶跨两步
     * 5 : f(3) + f(4)  到达第五个台阶只可能有两种情况 从第4个台阶跨一步  从第3个台阶跨两步
     * ......
     * n : f(n-2) + f(n-1) 到达第n个台阶只可能有两种情况 从第n-1个台阶跨一步  从第n-2个台阶跨两步
     *
     * 本质就是菲波拉
     */
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int f1 = 1;
        int f2 = 2;
        int f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

}
