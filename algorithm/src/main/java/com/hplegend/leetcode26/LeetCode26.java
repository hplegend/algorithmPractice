package com.hplegend.leetcode26;

public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        // 一轮遍历即可
        // 快慢指针

        int first = 0;
        int second = 1;

        int len = nums.length;

        if (len <=1) {
            return len;
        }

        for (;second<len ; ) {
            if (nums[second] == nums[first]) {
                ++second;
                continue;
            }

            first ++;
            nums[first] = nums[second];
            second++;
        }
        return first +1;
    }

}

