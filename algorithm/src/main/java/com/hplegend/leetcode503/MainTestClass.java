package com.hplegend.leetcode503;


/**
 * @author hp.he
 * @date 2020/10/21 13:31
 */
public class MainTestClass {


    public static void main(String[] args) {
        int nums[] = new int[]{2, 1, 2, 4, 1};
        Leetcode503 leetcode503 = new Leetcode503();
        int[] ret = leetcode503.nextGreaterElements(nums);
        for (int ele : ret) {
            System.out.println(ele);
        }
    }


}
