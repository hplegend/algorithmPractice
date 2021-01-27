package com.hplegend.leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hp.he
 * @date 2021/1/26 22:01
 */
public class Leetcode18 {


    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();

        if (null == nums || 0 == nums.length) {
            return quadruplets;
        }

        Arrays.sort(nums);

        // 排序，依次循环
        for (int first = 0; first < nums.length - 3; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            if (nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) {
                break;
            }

            if (nums[first] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                continue;
            }

            for (int second = first + 1; second < nums.length - 2; ++second) {

                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                if (nums[first] + nums[second] + nums[second + 1] + nums[second + 2] > target) {
                    break;
                }

                if (nums[first] + nums[second] + nums[nums.length - 1] + nums[nums.length - 2] < target) {
                    continue;
                }

                int remainTarget = target - (nums[first] + nums[second]);
                int pre = second + 1;
                int last = nums.length - 1;
                while (pre < last) {

                    if (nums[pre] + nums[last] > remainTarget) {
                        last--;

                    } else if (nums[pre] + nums[last] < remainTarget) {
                        pre++;
                    } else {

                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[first]);
                        tmp.add(nums[second]);
                        tmp.add(nums[pre]);
                        tmp.add(nums[last]);
                        quadruplets.add(tmp);

                        //相等的去除
                        while (pre < last && nums[pre] == nums[pre + 1]) {
                            pre++;
                        }
                        pre++;

                        //相等的去除
                        while (pre < last && nums[last - 1] == nums[last]) {
                            last--;
                        }

                        last--;
                    }
                }
            }
        }

        return quadruplets;
    }

}

