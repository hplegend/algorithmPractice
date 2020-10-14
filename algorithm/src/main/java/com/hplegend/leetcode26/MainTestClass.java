package com.hplegend.leetcode26;

public class MainTestClass {


    public static  void main(String []args) {
        LeetCode26 leetCode26 = new LeetCode26();

        int []nums = new int[] {0,2};

       int retLen = leetCode26.removeDuplicates(nums);
       System.out.println(retLen);
    }


}
