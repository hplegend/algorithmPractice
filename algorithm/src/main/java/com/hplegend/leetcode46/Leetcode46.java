package com.hplegend.leetcode46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hp.he
 * @date 2021/2/3 17:02
 */
public class Leetcode46 {


    private List<List<Integer>> finalRet = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        allSort(nums, 0);
        return finalRet;
    }

    public void allSort(int[] nums, int curPos) {

        if (curPos >= nums.length-1) {
            // copy
            int[] copy = Arrays.copyOf(nums, nums.length);

            List<Integer> copyList = new ArrayList<>();

            for (int ele : copy) {
                copyList.add(ele);
            }

            finalRet.add(copyList);

            return;

        }

        for (int index = curPos; index < nums.length; ++index) {
            // 交换
            swap(nums, curPos, index);

            // 继续递归
            allSort(nums, curPos + 1);

            // 回溯
            swap(nums, index, curPos);

        }
    }

    public void swap(int[] nums, int curPos, int nextPos) {
        int tmp = nums[curPos];
        nums[curPos] = nums[nextPos];
        nums[nextPos] = tmp;
    }
}
