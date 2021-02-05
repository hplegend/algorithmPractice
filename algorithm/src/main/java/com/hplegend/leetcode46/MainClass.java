package com.hplegend.leetcode46;

import java.util.List;

/**
 * @author hp.he
 * @date 2021/2/3 17:20
 */
public class MainClass {


    public static void main(String[] args) {
        Leetcode46 leetcode46 = new Leetcode46();

        int num[] = new int[]{1, 2, 3};

        List<List<Integer>> ret = leetcode46.permute(num);
        System.out.println(ret);
    }

}
