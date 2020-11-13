package com.hplegend.leetcode121;

/**
 * @author hp.he
 * @date 2020/11/14 0:31
 */
public class Leetcode121 {

    public int maxProfit(int[] prices) {


        /**
         * //给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
         * //
         * // 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
         * //
         * // 注意：你不能在买入股票前卖出股票。
         * //
         * //
         * //
         * // 示例 1:
         * //
         * // 输入: [7,1,5,3,6,4]
         * //输出: 5
         * //解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
         * //     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
         * //
         * //
         * // 示例 2:
         * //
         * // 输入: [7,6,4,3,1]
         * //输出: 0
         * //解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
         * */


        // 动归解法写一写

        // 一轮for 循环
        // 记录已经走过的最小的
        // 计算后面的利润
        // 思路很重要，不要一上来就做，先理解好目标，然后再开始。
        // 做需求开发也是一样的，先明确需求，然后再开始working

        int len = prices.length;
        int profit = 0;
        int minValue = Integer.MAX_VALUE;
        for (int ind = 0; ind < len; ++ind) {
            // 目标一，找最小的数
            // 利润一定是在最小的找到后再计算的。但是有可能最小的在最后，因此最大利润不能直接置位0
            if (prices[ind] < minValue) {
                minValue = prices[ind];
            } else if (prices[ind] - minValue > profit) {
                // 目标二，找利润最大的
                profit = prices[ind] - minValue;
            }
        }
        return profit;
    }

}
