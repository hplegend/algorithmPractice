package com.hplegend.leetcode16;

import java.util.Arrays;

public class Leetcode16 {


    // 固定一个，遍历其余两个。 双指针应用
    // 这个题目的思考方向： 先是暴力破解； 优化暴力破解的方法就是排序，固定一个，求另外两个。这样用n的立方优化为n的平方。 利用双指针的优势。

    public int threeSumClosest(int[] nums, int target) {

        // 排序
        // jdk 自带的排序方法 使用的是快排的思路
        Arrays.sort(nums);
        // 插，这里有坑。
        // 不能用 maxValue 或者 minValue。 因为会存在加减超出限制的情况
        int maxValue = 100000000;
        int len = nums.length;
        for (int first = 0 ; first < len; ++ first) {
            if (first  > 0 && nums[first] == nums[first -1]) {
                continue;
            }

            int second = first+1;
            int three = len -1;

            // 变相的穷举
            while (second < three) {
                int threeNumSum = nums[first] + nums[second] + nums[three];

                if (target == threeNumSum) {
                    return threeNumSum;
                }

              if (Math.abs(threeNumSum - target) <  Math.abs(maxValue - target)) {
                  maxValue = threeNumSum;
              }

                if (threeNumSum > target) {
                    int tmpK = three -1;
                    while (tmpK>second && nums[tmpK] == nums[three]){
                        //
                        tmpK = tmpK -1;

                    }
                    three  = tmpK;
                } else {
                    int tmpK = second +1;
                    while (tmpK< three && nums[tmpK] == nums[second]){
                        //
                        tmpK = tmpK +1;

                    }
                    second  = tmpK;

                }
            }
        }

        return maxValue;
    }

}
