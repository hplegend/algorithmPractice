package com.hplegend.leetcode300;

/**
 * @author hp.he
 * @date 2021/1/26 21:32
 */
public class Leetcode300 {


    public int lengthOfLIS(int[] nums) {

        // dp。 这里两层for 循环
        if (nums.length == 0) {
            return 0;
        }

        int[] mem = new int[nums.length];
        mem[0] = 1;


        int maxLen = 1;

        for (int i = 1; i < nums.length; ++i) {
            mem[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    // 添加一个当前的j，与不添加，哪个更大
                    mem[i] = Math.max(mem[i], mem[j] + 1);
                }
            }
            // 寻找当前的一个最大
            // 用单个变量存储，而不用数组存储每一步，更加节约空间
            maxLen = Math.max(maxLen, mem[i]);
        }

        return maxLen;
    }

}
