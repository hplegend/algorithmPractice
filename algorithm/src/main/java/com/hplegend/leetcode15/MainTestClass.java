package com.hplegend.leetcode15;

import java.util.List;

public class MainTestClass {

    public static void main(String []args) {
        Leetcode15 leetcode15 = new Leetcode15();
        int [] nums = new int []{-1,0,1,2,-1,-4};
       List<List<Integer>> ret = leetcode15.threeSum(nums);

       for (List<Integer> ele : ret) {
           for (Integer var : ele) {
               System.out.print(var+" ");
           }
           System.out.println();
       }
    }


}
