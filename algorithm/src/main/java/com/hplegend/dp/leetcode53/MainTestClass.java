package com.hplegend.dp.leetcode53;

/**
 * @author hp.he
 * @date 2020/10/4 16:19
 */
public class MainTestClass {
    public static void main(String[] args) {

        Leetcode53 leetcode53 = new Leetcode53();

        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};


        int ret = leetcode53.maxSubArray(arr);
        System.out.print(ret);

    }

}
