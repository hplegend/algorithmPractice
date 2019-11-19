package com.hplegend.leetcode435;

/**
 * @author hp.he
 * @date 2019/11/19 13:52
 */
public class MainClass {

    public static void main(String[] args) {
        LeetCode435 leetCode435 = new LeetCode435();
        int[][] interval = new int[][]{
                {1, 4}, {2, 5}, {5, 7}
        };


        System.out.println(leetCode435.eraseOverlapIntervals(interval));
    }
}
