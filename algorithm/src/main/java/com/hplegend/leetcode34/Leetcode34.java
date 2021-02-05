package com.hplegend.leetcode34;

/**
 * @author hp.he
 * @date 2021/2/5 15:22
 */
public class Leetcode34 {

    public int[] searchRange(int[] nums, int target) {

        int lowBound = findLowBound(nums, target);
        int upBound = findUpbound(nums, lowBound, target);

        return new int[]{lowBound, upBound};
    }


    public int findLowBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int start = -1;
        int end = nums.length;
        while (start + 1 < end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start + 1] == target) {
            return start + 1;
        }

        return -1;
    }


    public int findUpbound(int[] nums, int lowBoundIndex, int target) {
        if (lowBoundIndex == -1) {
            return -1;
        }

        int upBound = lowBoundIndex;
        for (int i = lowBoundIndex; i < nums.length; ++i) {
            if (nums[i] == target) {
                upBound = i;
            } else {
                break;
            }
        }

        return upBound;
    }


    // 思路： 找到下边界。然后顺序找


}
