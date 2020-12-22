package com.hplegend.leetcode16;

public class MainTestClass {


    public static void main(String []args) {
        Leetcode16 leetcode16 = new Leetcode16();
        int []nums = new int[]{-3,-2,-5,3,-4};
        // [-3,-2,-5,3,-4] -1
      int ret =  leetcode16.threeSumClosest(nums,-1);
      System.out.println(ret);
    }

}
