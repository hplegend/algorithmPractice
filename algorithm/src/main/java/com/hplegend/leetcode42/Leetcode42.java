package com.hplegend.leetcode42;

/**
 * @author hp.he
 * @date 2021/1/24 17:52
 */
public class Leetcode42 {


    /**
     * //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //
     * //
     * //输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * //输出：6
     * //解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：height = [4,2,0,3,2,5]
     * //输出：9
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // n == height.length
     * // 0 <= n <= 3 * 104
     * // 0 <= height[i] <= 105
     * //
     * // Related Topics 栈 数组 双指针 动态规划
     */

    public int trap(int[] height) {
        return dp(height);
    }


    // 暴力解法

    public int ordinary(int[] height) {
        // 对于每一个位置，向左向右找到大于它的值，然后计算与左右最小的高度差的高度
        int sumRet = 0;
        int totalSize = height.length;

        for (int i = 0; i < totalSize; ++i) {
            int maxLeft = 0;
            int maxRight = 0;

            for (int leftDir = i; leftDir >= 0; leftDir--) {
                maxLeft = Math.max(maxLeft, height[leftDir]);
            }

            for (int rightDir = i; rightDir >= 0; rightDir++) {
                maxRight = Math.max(maxRight, height[rightDir]);
            }

            sumRet += Math.min(maxLeft, maxRight) - height[i];
        }

        return sumRet;
    }


    /**
     * 这里就是备忘录的应用罢了，也不是正儿八经的dp
     */
    public int dp(int[] height) {

        if (null == height || 0 == height.length) {
            return 0;
        }

        int sumRet = 0;
        int totalSize = height.length;

        int[] leftMem = new int[totalSize];
        int[] rightMem = new int[totalSize];


        leftMem[0] = height[0]; // 边界值，肯定是它本身
        for (int leftItr = 1; leftItr < totalSize; ++leftItr) {
            leftMem[leftItr] = Math.max(height[leftItr - 1], height[leftItr]);
        }


        rightMem[totalSize-1] = height[totalSize - 1]; // 边界值，肯定是它本身
        for (int rightItr = totalSize - 2; rightItr >= 0; --rightItr) {
            rightMem[rightItr] = Math.max(height[rightItr + 1], height[rightItr]);
        }


        // 用空间换时间的做法，在算法中很常见
        for (int itr = 1; itr < totalSize - 1; ++itr) {
            sumRet += Math.min(leftMem[itr], rightMem[itr]) - height[itr];
        }
        return sumRet;
    }


}
