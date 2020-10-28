package com.hplegend.leetcode27;

public class Leetcod27 {


    // 双指针
    // 原地移动即可
    // 注意边界条件
    // 注意全部删除，意思是空集合
    public int removeElement(int[] nums, int val) {

        int first =0;
        int last = nums.length -1;

        for (;first<= last;) {
            if (nums[first] == val) {
                while (first<= last && nums[last] == val) {
                    last --;
                }
                if (last< first) {
                    break;
                }
                nums[first] = nums[last];
                first ++;
                last--;
            } else  {
                first ++;
            }
        }
        return first;
    }
}
