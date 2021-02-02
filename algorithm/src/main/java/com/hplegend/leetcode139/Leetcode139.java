package com.hplegend.leetcode139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hp.he
 * @date 2021/2/1 18:44
 */
public class Leetcode139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // 暴力穷举
        // dp用于记录到某一个位置上是否有结果。
        // 你可能比较模糊，这里的结果要不要变化，其实，这里有一个满足就行，不需要求最优值。

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
