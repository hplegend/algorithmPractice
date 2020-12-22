package com.hplegend.dp.leetcode53;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划

import java.util.HashMap;
import java.util.Map;

/**
 * @author hp.he
 * @date 2020/10/4 16:14
 */
public class Leetcode53 {


    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            // 这里的这个pre，不重置吗？？
            // 这样拆分，更容易理解一些
            int oldSum = pre + x;
            if (oldSum > x) {
                // 这里就是最有子结构的体现
                pre = oldSum;
            } else {
                // 这里就是重置
                pre = x;
            }

            // 判断最后的结果
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


    public int maxSubArrayStanderd(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public int maxSubArrayMy(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        // 初始化为Integer.min

        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        // 开始循环迭代
        // round相当于步长
        for (int round = 0; round < len; ++round) {
            for (int iter = 0; iter + round < len; ++iter) {
                int newPos = iter + round;
                // 初始化本元素
                if (round == 0) {
                    dp[iter][newPos] = nums[newPos];
                } else {
                    int newSum = dp[iter][newPos - 1] + nums[newPos];
                    dp[iter][newPos] = newSum;
                }

                System.out.print(dp[iter][newPos] + ",");
            }
            System.out.println("\n");
        }

        int finalSumRet = Integer.MIN_VALUE;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                if (dp[i][j] > finalSumRet) {
                    finalSumRet = dp[i][j];
                }
            }
        }

        return finalSumRet;
    }
}
