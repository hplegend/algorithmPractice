package com.hplegend.leetcode398;

import java.util.Random;

/**
 * @author hp.he
 * @date 2020/12/28 18:13
 */
public class Leetcode398 {
    private int[] nums;

    public Leetcode398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {

        Random r = new Random();

        /**
         * 记录重复出现的
         * */
        int n = 0;

        /**
         * 记录真实返回值的index
         * */
        int index = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                n++;
                /**
                 * 这里依赖r.nextInt是完全真实随机的。
                 *
                 *
                 *
                 * */
                if (r.nextInt() % n == 0) {
                    index = i;
                }

            }
        }


        return index;

    }

}
