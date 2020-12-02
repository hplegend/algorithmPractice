package com.hplegend.leetcode241;

import java.util.List;

/**
 * @author hp.he
 * @date 2020/12/2 13:28
 */
public class MainClass {


    public static void main(String[] args) {

        Leetcode241 leetcode241 = new Leetcode241();

        List<Integer> ret = leetcode241.diffWaysToCompute("2*3-4*5");


        for (Integer var : ret) {
            System.out.println(var);
        }

    }

}
