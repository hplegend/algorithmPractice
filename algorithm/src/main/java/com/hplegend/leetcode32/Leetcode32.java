package com.hplegend.leetcode32;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hp.he
 * @date 2021/2/6 15:35
 */
public class Leetcode32 {


    public int longestValidParentheses(String s) {
        int maxAns = 0;

        if (s.length() == 0) {
            return maxAns;
        }

        int[] dp = new int[s.length()];

        // 因为要比较单前位置与它的前一个位置
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // 如果前一个正好匹配上，那一定是正确的
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    // 如果前一个不匹配，那么找到前一个已经配置上位置的前一个，判断是否能匹配
                    //
                    if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        // 注意这里的地推关系
                        // （）(（（））) -- 此类也是非常正确的
                        dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                }
                maxAns = Math.max(maxAns, dp[i]);
            }
        }
        return maxAns;
    }


    public int stack(String s) {

        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        // 这个-1是必须的，就是为了表示初始的连续性，一旦中途断链了，那么这个-1其实已经弹出来了
        // 如： （）（（）），
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;


    }

}
