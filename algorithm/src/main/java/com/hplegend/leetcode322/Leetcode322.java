package com.hplegend.leetcode322;

//You are given coins of different denominations and a total amount of money amo
//unt. Write a function to compute the fewest number of coins that you need to mak
//e up that amount. If that amount of money cannot be made up by any combination o
//f the coins, return -1.
//
// You may assume that you have an infinite number of each kind of coin.
//
//
// Example 1:
//
//
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
//
//
// Example 2:
//
//
//Input: coins = [2], amount = 3
//Output: -1
//
//
// Example 3:
//
//
//Input: coins = [1], amount = 0
//Output: 0
//
//
// Example 4:
//
//
//Input: coins = [1], amount = 1
//Output: 1
//
//
// Example 5:
//
//
//Input: coins = [1], amount = 2
//Output: 2
//
//
//
// Constraints:
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
//
// Related Topics Dynamic Programming


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hp.he
 * @date 2020/10/4 16:14
 */
public class Leetcode322 {

    private static Map<Integer, Integer> calMinMap = new HashMap<>();


    // 最后返回的肯定数量
    public int coinChange(int[] coins, int amount) {


        return 0;
    }

    public int oridinaryRecuersive(int[] coins, int amount) {

        // 既然是递归，那么递归出口总得定义吧？
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        int ret = 65535;

        // 对于当前amount，尝试放置每一种硬币
        for (int coin : coins) {
            int remainAmount = amount - coin;
            int remainLessConis = oridinaryRecuersive(coins, remainAmount);

            if (remainLessConis == -1) {
                continue;
            }

            if (remainLessConis + 1 < ret) {
                ret = remainLessConis + 1;
            }
        }

        // 对最后结果的处理
        // 如果找到了，返回a，没有找到返回b
        if (ret != 65535) {
            return ret;
        }
        return -1;
    }

    public int tableRecuersive(int[] coins, int amount) {

        if (calMinMap.containsKey(amount)) {
            return calMinMap.get(amount);
        }


        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        int minRet = 65535;
        for (int coin : coins) {
            int remainAmount = amount - coin;
            int subProblemMinRet = tableRecuersive(coins, remainAmount);

            if (-1 == subProblemMinRet) {
                continue;
            }

            if (subProblemMinRet + 1 < 65535) {
                minRet = subProblemMinRet + 1;
            }
        }

        if (minRet != 65535) {
            calMinMap.put(amount, minRet);
            return minRet;
        }

        return -1;
    }

    // 自下而上？
    public int dp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < amount + 1; ++i) {
            dp[i] = 65535;
        }

        // base case
        dp[0] = 0;

        for (int i = 0; i < amount + 1; ++i) {
            for (int coin : coins) {
                int sumProblemt = i - coin;
                if (sumProblemt < 0) {
                    continue;
                }

                int sub = dp[sumProblemt];

                // 子问题的解
                if (sub + 1 < dp[i]) {
                    dp[i] = sub + 1;
                }
            }
        }

        return dp[amount] == 65535 ? -1 : dp[amount];
    }

}
