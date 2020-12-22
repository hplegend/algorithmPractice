package com.hplegend.leetcode41;

/**
 * @author hp.he
 * @date 2020/12/15 18:32
 */
public class Leetcode41 {


    public int firstMissingPositive(int[] nums) {

        int len = nums.length;

        // 所有小于0的数据，全部设置成长度的最大值
        for (int i = 0; i < len; ++i) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }


        // 如果数再【0-n】范围内，则设置该数所在下标的数为负数
        for (int i = 0; i < len; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= len) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // 找到第一不在0-n范围内的
        // 利用现有空间做标记，good
        for (int i = 0; i < len; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return len + 1;

    }


}
