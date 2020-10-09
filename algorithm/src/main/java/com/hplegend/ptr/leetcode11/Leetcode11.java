package com.hplegend.ptr.leetcode11;

/**
 * @author hp.he
 * @date 2020/10/9 17:11
 */
public class Leetcode11 {

    // 暴力破解： O（n2）

    int maxAreaBaoli(int[] height) {
        int maxValue = 0;
        int len = height.length;

        for (int first = 0; first < len - 1; ++first) {
            for (int second = first + 1; second < len; ++second) {

                int width = (second - first);
                int minHeight = height[second] < height[first] ? height[second] : height[first];
                int newArea = width * minHeight;

                if (maxValue < newArea) {
                    maxValue = newArea;
                }
            }
        }
        return maxValue;
    }


    public int maxArea(int[] height) {
        // 一轮for循环
        int len = height.length;
        int maxValue = 0;

        // 题目保证大于2位，不做判空处理
        int firstPtr = 0;

        for (int secondPtr = 1; secondPtr < len; ++secondPtr) {

            int width = secondPtr - firstPtr;
            int minHeight = height[firstPtr] > height[secondPtr] ? height[secondPtr] : height[firstPtr];
            int calcValue = minHeight * width;
            if (maxValue < calcValue) {
                maxValue = calcValue;
            } else {
                firstPtr = firstPtr + 1;
            }
        }

        return maxValue;
    }


    /**
     * 核心内容： 长度最长的，高度最终影响面积的增减。 向着递增的方向递进
     * 时间复杂度 O（n/2）
     */

    public int maxArea2(int[] height) {
        // 一轮for循环
        int len = height.length;
        int maxValue = 0;

        // 题目保证大于2位，不做判空处理
        int firstPtr = 0;
        int secondPtr = len - 1;


        // 不能去等号
        // 因为他们的步长就是1
        for (; firstPtr < secondPtr; ) {
            int width = secondPtr - firstPtr;
            int minHeight = height[firstPtr] > height[secondPtr] ? height[secondPtr] : height[firstPtr];
            int calcValue = minHeight * width;
            if (maxValue < calcValue) {
                maxValue = calcValue;
            }
            // 下一步移动，向大的值方向移动
            // 计算左边最值
            int firstStepPtr = firstPtr + 1;
            int secondStepPtr = secondPtr - 1;

            int firstStepValue = (width - 1) *
                    (height[firstStepPtr] > height[secondPtr] ? height[secondPtr] : height[firstStepPtr]);

            int secondStepValue = (width - 1) *
                    (height[firstPtr] > height[secondStepPtr] ? height[secondStepPtr] : height[firstPtr]);

            if (firstStepValue < maxValue && secondStepValue < maxValue) {
                return maxValue;
            }

            if (firstStepValue > maxValue) {
                firstPtr = firstStepPtr;
            }

            if (secondStepValue > maxValue) {
                secondPtr = secondStepPtr;
            }
        }
        return maxValue;
    }


    public int maxArea3(int[] height) {
        // 一轮for循环
        int len = height.length;
        int maxValue = 0;

        // 题目保证大于2位，不做判空处理
        int firstPtr = 0;
        int secondPtr = len - 1;


        // 不能去等号
        // 因为他们的步长就是1
        // 一轮遍历，找最大
        for (; firstPtr < secondPtr; ) {
            int width = secondPtr - firstPtr;
            int minHeight = height[firstPtr] > height[secondPtr] ? height[secondPtr] : height[firstPtr];
            int calcValue = minHeight * width;
            if (maxValue < calcValue) {
                maxValue = calcValue;
            }
            // 下一步移动，向大的值方向移动
            // 留下长度大的，移动长度小的
            // 实际上问题已经退化成找两个相距最远的最大数，与第二大数
            if (height[firstPtr] < height[secondPtr]) {
                firstPtr++;
            } else {
                secondPtr--;
            }

        }
        return maxValue;
    }

}
