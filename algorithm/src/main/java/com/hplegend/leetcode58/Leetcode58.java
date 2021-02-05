package com.hplegend.leetcode58;

/**
 * @author hp.he
 * @date 2021/2/3 12:11
 */
public class Leetcode58 {

    public int lengthOfLastWord(String s) {
        if (null == s || s.length() <= 0) {
            return 0;
        }
        int sLen = s.length();
        int len = 0;

        // 从后向前

        for (int index = sLen - 1; index >= 0; --index) {
            if (len == 0 && s.charAt(index) == ' ') {
                continue;
            }
            if (len > 0 && s.charAt(index) == ' ') {
                return len;
            }

            ++len;
        }

        return len;
    }

}
