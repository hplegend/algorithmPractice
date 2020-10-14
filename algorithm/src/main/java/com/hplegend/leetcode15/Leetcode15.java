package com.hplegend.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        // 双指针
        // 去重

        List<List<Integer>> ret = new ArrayList<>();

        Arrays.sort(nums);
        int len = nums.length;

        int first;
        int second;
        int three;

        for (first = 0; first < len; ++first) {
            // 去重复
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            three = len - 1;
            int target = -nums[first];

            for (second = first + 1; second < len; ++second) {
                if (second > first + 1  && nums[second] == nums[second - 1]) {
                   continue;
                }

                while (second < three && nums[second] + nums[three] > target) {
                    three--;
                }

                if (second == three) {
                    break;
                }

                if (nums[second] + nums[three] == target) {
                    List<Integer> singleRet = new ArrayList<>();
                    singleRet.add(nums[first]);
                    singleRet.add(nums[second]);
                    singleRet.add(nums[three]);
                    ret.add(singleRet);
                }
            }

        }

        return ret;
    }

}
