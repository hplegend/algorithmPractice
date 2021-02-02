package com.hplegend.leetcode213;

import java.util.Arrays;

/**
 * @author hp.he
 * @date 2021/2/1 14:24
 */
public class Leetcode213 {

    public int rob(int[] nums) {

        int[] mem1 = new int[nums.length];
        Arrays.fill(mem1, -1);

        int[] mem2 = new int[nums.length];
        Arrays.fill(mem2, -1);

        if (nums.length == 1) {
            return nums[0];
        }

        // 两次递归，会超时
        int caseOne = robRange(nums, 0, nums.length - 2, mem1);
        int caseThress = robRange(nums, 1, nums.length - 1, mem2);

        return Math.max(caseOne, caseThress);
    }

    public int robRange(int[] nums, int start, int end, int[] mem) {

        if (start > end) {
            return 0;
        }

        if (mem[start] != -1) {
            return mem[start];
        }

        // 开始选择
        // 递归，解决掉了最小问题，然后依次解决到第二大，第三大问题。
        // 递归的核心在于模式
        int notDo = robRange(nums, start + 1, end, mem);
        int toDo = robRange(nums, start + 2, end, mem) + nums[start];

        int max = notDo > toDo ? notDo : toDo;
        mem[start] = max;

        return max;
    }
}
