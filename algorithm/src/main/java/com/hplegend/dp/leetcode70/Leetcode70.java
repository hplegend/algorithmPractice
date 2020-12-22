package com.hplegend.dp.leetcode70;

/**
 * @author hp.he
 * @date 2020/11/11 18:13
 */

public class Leetcode70 {

    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划, 递归，迭代


    /**
     * 递归解法
     * f(n) = f(n-1) + f(n-2): 意思是，最后可以跳一阶或者跳两阶。
     * 递归的终止条件： n=1,只能跳1，n = 2，可以选择跳1或者2阶，一共两种方法
     */
    public int climbStairsWithRecurring(int n) {

        if (1 == n) {
            return 1;
        }

        if (2 == n) {
            return 2;
        }

        return climbStairsWithRecurring(n - 1) + climbStairsWithRecurring(n - 2);
    }


    // 这里的迭代实际上已经是动归了
    public int climbStairsWithDiedai(int n) {

        if (1 == n) {
            return 1;
        }

        if (2 == n) {
            return 2;
        }

        int preOne = 1;
        int preTwo = 2;

        for (int i = 3; i <= n; ++i) {
            int cur = preOne + preTwo;
            preOne = preTwo;
            preTwo = cur;
        }

        return preTwo;
    }


}
