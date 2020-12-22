package com.hplegend.leetcode66;

/**
 * @author hp.he
 * @date 2020/12/17 18:17
 */
public class MainClass {


    public static void main(String[] args) {
        Leetcode66 leetcode66 = new Leetcode66();


        int[] digital = new int[]{9, 9, 9, 9};
        int[] ret = leetcode66.plusOne(digital);

        for (int ele : ret) {
            System.out.print(ele + " ");
        }
    }

}
