package com.hplegend.leetcode279;

import java.util.Arrays;

/**
 * @author hp.he
 * @date 2021/2/7 14:59
 */
public class Leetcode279 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        // 空间换时间
        int squeraNum = (int) Math.sqrt(n)+1;
        int[] suqueValue = new int[squeraNum];
        for (int i = 1; i < squeraNum; ++i) {
            suqueValue[i] = i * i;
        }

        // 开始带记忆的穷举迭代
        // 用每一个可以开方的数去枚举
        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < squeraNum; ++s) {
                // i 能开方
                if (i < suqueValue[s]) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - suqueValue[s]] + 1);
            }
        }

        return dp[n];
    }

}
