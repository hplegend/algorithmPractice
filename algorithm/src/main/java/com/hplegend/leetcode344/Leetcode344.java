package com.hplegend.leetcode344;

/**
 * @author hp.he
 * @date 2020/10/28 22:33
 */
public class Leetcode344 {

    public void reverseString(char[] s) {
        // 首尾遍历，双指针
        int first = 0;
        int last = s.length - 1;

        for (; first < last; first++, last--) {
            char tmp = s[first];
            s[first] = s[last];
            s[last] = tmp;
        }

    }

}
