package com.hplegend.leetcode128;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hp.he
 * @date 2021/2/7 15:24
 */
public class Leetcode128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int index = 0; index < nums.length; ++index) {
            numSet.add(nums[index]);
        }
        int maxAns = 0;

        for (int numV : numSet) {
            //
            // 由特征决定，这里是避免重复寻找，因此要进行一次过滤
            if (!numSet.contains(numV - 1)) {
                int currentNum = numV;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                maxAns = Math.max(maxAns, currentStreak);
            }
        }

        return maxAns;
    }

}
