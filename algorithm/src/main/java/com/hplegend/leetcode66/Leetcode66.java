package com.hplegend.leetcode66;

import java.util.Arrays;

/**
 * @author hp.he
 * @date 2020/12/17 18:17
 */
public class Leetcode66 {

    public int[] plusOne(int[] digits) {

        // 逆向从前往后
        // 注意第一位的进位

        int len = digits.length;

        int addNum = 1;

        int promotion = 0;

        for (int index = len - 1; index >= 0; --index) {

            int sum = digits[index] + addNum + promotion;

            addNum = 0;
            promotion = 0;

            if (sum >= 10) {
                promotion = sum / 10;
                sum = sum % 10;
            }

            digits[index] = sum;
        }

        // 需要copy一份
        if (promotion > 0) {
            int[] newCopy = new int[len + 1];

            newCopy[0] = promotion;
            for (int i = 0; i < len; ++i) {
                newCopy[i + 1] = digits[i];
            }

            return newCopy;
        } else {
            return digits;
        }
    }
}
