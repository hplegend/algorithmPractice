package com.hplegend.leetcode62;

/**
 * @author hp.he
 * @date 2021/2/7 15:56
 */
public class Leetcode62 {

    // 穷举

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // 初始化
        // dp 要考虑初始化，递归要考虑出口

        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; ++j) {
            dp[0][j] = 1;
        }


        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
