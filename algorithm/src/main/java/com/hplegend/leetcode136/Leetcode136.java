package com.hplegend.leetcode136;

//Given a non-empty array of integers, every element appears twice except for on
//e. Find that single one.
//
// Note:
//
// Your algorithm should have a linear runtime complexity. Could you implement i
//t without using extra memory?
//
// Example 1:
//
//
//Input: [2,2,1]
//Output: 1
//
//
// Example 2:
//
//
//Input: [4,1,2,1,2]
//Output: 4
//
// Related Topics Hash Table Bit Manipulation

/**
 * @author hp.he
 * @date 2020/2/9 17:02
 */
public class Leetcode136 {

    // 最简单的方法，就是异或
    // 另外，用hashMap也行
    public int singleNumber(int[] nums) {
        int andValue = nums[0];
        for (int i=1; i<nums.length ; ++i) {
            andValue = andValue ^ nums[i];
        }
        return andValue;
    }


}
