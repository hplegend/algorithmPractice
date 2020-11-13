package com.hplegend.leetcode191;

/**
 * @author hp.he
 * @date 2020/10/29 14:41
 */
public class Leetcode191 {


    //编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
//
//
//
// 示例 1：
//
// 输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
//
//
// 示例 2：
//
// 输入：00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。

    public int hammingWeight(int n) {
        // 最简单的方式就是位运算
        // 暴力破解，就是遍历
        int oneCnt = 0;
        while ((n = (n & n - 1)) != 0) {
            oneCnt++;
        }

        return oneCnt;
    }

}