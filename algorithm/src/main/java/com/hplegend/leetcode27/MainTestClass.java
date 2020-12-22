package com.hplegend.leetcode27;

public class MainTestClass {
    public static void main(String[] args) {
        Leetcod27 leetcod27 = new Leetcod27();
        int[] nums = new int[]{6};
        int len = leetcod27.removeElement(nums, 6);
        System.out.println(len);
        for (int i = 0; i < len; ++i) {
            System.out.println(nums[i]);
        }
    }

}
