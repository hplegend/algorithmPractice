package com.hplegend.leetcode75;

/**
 * @author hp.he
 * @date 2020/2/10 17:13
 */
public class MainClass {

    public static void main (String []args) {
        Leetcode75 leetcode75 = new Leetcode75();
        int []nums = new int[]{0,1,2};
        leetcode75.sortColors3(nums);
        for (int var : nums) {
            System.out.print(var);
            System.out.print(" ");
        }

    }

}
