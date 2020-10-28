package com.hplegend.leetcode503;


import java.util.Stack;

/**
 * @author hp.he
 * @date 2020/10/21 13:30
 */
public class Leetcode503 {

    public int[] nextGreaterElements(int[] nums) {

        // 核心点：
        // 1、栈。 栈顶元素是是大于当前元素的最小值。
        // 2、循环。实现方式：扩大数组为2倍；逻辑循环思路
        // 3、逆向遍历。原因：留下大的，移除小。保证栈顶元素，是单前的最佳值.

        int len = nums.length;
        int[] ret = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * len - 1; i >= 0; --i) {

            // 逆向查找。如果栈顶小于当前元素，那么可以直接抛弃了，栈顶已经被完美的遮挡了
            while (!stack.isEmpty() && stack.peek() <= nums[i % len]) {
                stack.pop();
            }

            ret[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }

        return ret;
    }
}
