package com.hplegend.leetcode239;

/**
 * @author hp.he
 * @date 2020/12/8 17:01
 */
public class MainTestClass {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};

        Leetcode239 leetcode239 = new Leetcode239();
        int ret[] = leetcode239.maxSlidingWindow(nums, 3);

        for (int ele : ret) {
            System.out.println(ele);
        }


    }

}
