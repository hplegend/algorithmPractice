package com.hplegend.leetcode516;

/**
 * @author hp.he
 * @date 2021/1/25 14:14
 */
public class Leetcode516 {

    /**
     * //给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
     * //
     * //
     * //
     * // 示例 1:
     * //输入:
     * //
     * // "bbbab"
     * //
     * //
     * // 输出:
     * //
     * // 4
     * //
     * //
     * // 一个可能的最长回文子序列为 "bbbb"。
     * //
     * // 示例 2:
     * //输入:
     * //
     * // "cbbd"
     * //
     * //
     * // 输出:
     * //
     * // 2
     * //
     * //
     * // 一个可能的最长回文子序列为 "bb"。
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= s.length <= 1000
     * // s 只包含小写英文字母
     * //
     * // Related Topics 动态规划
     */

    // 暴力穷举
    // 带备忘录
    public int longestPalindromeSubseq(String s) {

        if (null == s || s.length() == 0) {
            return 0;
        }

        int len = s.length();

        // dp数组
        int[][] mem = new int[len + 1][len + 1];

        // 边界条件
        // 单一元素都是回文
        for (int itr = 0; itr < len; ++itr) {
            mem[itr][itr] = 1;
        }

        // 从头开始遍历
        // 正向地推好像不行
        for (int itr = 0; itr < len; ++itr) {
            for (int secondItr =0; secondItr < itr; ++secondItr) {
                if (s.charAt(itr) == s.charAt(secondItr)) {
                    mem[secondItr][itr] = mem[secondItr + 1][itr - 1] + 2;
                } else {
                    mem[secondItr][itr] = Math.max(mem[secondItr + 1][itr], mem[secondItr][itr - 1]);
                }
            }
        }


       /* for (int itr = len - 1; itr >= 0; --itr) {
            for (int secondItr = itr + 1; secondItr < len; ++secondItr) {
                if (s.charAt(itr) == s.charAt(secondItr)) {
                    mem[secondItr][itr] = mem[secondItr + 1][itr - 1] + 2;
                } else {
                    mem[secondItr][itr] = Math.max(mem[secondItr + 1][itr], mem[secondItr][itr - 1]);
                }
            }
        }*/


        return mem[0][len - 1];
    }
}
