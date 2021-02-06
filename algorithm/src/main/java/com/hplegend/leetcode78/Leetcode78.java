package com.hplegend.leetcode78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hp.he
 * @date 2021/2/6 13:39
 */
public class Leetcode78 {

    List<List<Integer>> finalRet = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subSetParam = new ArrayList<>(nums.length);
        dfs(0, nums, subSetParam);
        return finalRet;
    }


    public void dfs(int pos, int[] nums, List<Integer> subSet) {
        if (pos == nums.length) {
            // copy 构造
            finalRet.add(new ArrayList<Integer>(subSet));
            return;
        }

        subSet.add(nums[pos]);
        dfs(pos + 1, nums, subSet);
        // array size是大小，length是长度
        subSet.remove(subSet.size() - 1);
        dfs(pos + 1, nums, subSet);
    }


}
