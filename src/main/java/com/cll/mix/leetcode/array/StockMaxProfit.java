package com.cll.mix.leetcode.array;

/**
 * 买卖股票的最佳时机 II
 * 规则：
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例1：
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 示例2：
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * create on 2019-06-11 19:30:00
 */
public class StockMaxProfit {

    public static void main(String[] args) {
        int[] stocks = {1,2,1,10};
        System.out.println(maxProfit(stocks));
    }

    public static int maxProfit(int[] stocks){
        if(stocks.length == 0){
            return 0;
        }
        // 利润
        int profit = 0;
        for (int a = 0; a < stocks.length-1; a++){
            // 当且仅当 stocks[a] < stocks[a+1] 才进行交易
            if (stocks[a] < stocks[a+1]){
                profit += (stocks[a+1]-stocks[a]);
            }
        }

        return profit;
    }

}
