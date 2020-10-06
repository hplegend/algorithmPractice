package com.hplegend.dp.leetcode5;

/**
 * @author hp.he
 * @date 2020/10/6 13:14
 */
public class Leetcode5 {

    /**
     * 循环迭代：
     * 长度为1，长度为2，长度为3
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String retStr = "";
        for (int round = 0; round < len; ++round) {
            for (int iterStart = 0; iterStart + round < len; ++iterStart) {
                int lastPos = iterStart + round;

                // 长度为1的字符串，肯定是回文
                if (round == 0) {
                    dp[iterStart][lastPos] = true;
                } else if (round == 1) {
                    // 长度为2的字符串,判断是否相等
                    dp[iterStart][lastPos] = (s.charAt(iterStart) == s.charAt(lastPos));
                } else {
                    // 长度大于2的字符串，先判断中间是不是回文
                    // 如果是回文，在判断新加的一个元素与整个子字符串的首字符是否相等
                    // 在满足上面的所有的情况下，说明该子串是回文
                    if (!dp[iterStart + 1][lastPos - 1]) {
                        dp[iterStart][lastPos] = false;
                    } else if (s.charAt(iterStart) != s.charAt(lastPos)) {
                        dp[iterStart][lastPos] = false;
                    } else {
                        dp[iterStart][lastPos] = true;
                    }
                }

                // 如果是回文，再判断长度
                if (dp[iterStart][lastPos] && round + 1 > retStr.length()) {
                    retStr = s.substring(iterStart, iterStart + round + 1);
                }
            }
        }

        return retStr;
    }

}
