package com.hplegend.leetcode239;

import java.util.LinkedList;

/**
 * @author hp.he
 * @date 2020/12/8 17:00
 */
public class Leetcode239 {
    /**
     * //给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * //
     * //
     * // 返回滑动窗口中的最大值。
     * //
     * //
     * //
     * // 进阶：
     * //
     * // 你能在线性时间复杂度内解决此题吗？
     * //
     * //
     * //
     * // 示例:
     * //
     * // 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * //输出: [3,3,5,5,6,7]
     * //解释:
     * //
     * //  滑动窗口的位置                最大值
     * //---------------               -----
     * //[1  3  -1] -3  5  3  6  7       3
     * // 1 [3  -1  -3] 5  3  6  7       3
     * // 1  3 [-1  -3  5] 3  6  7       5
     * // 1  3  -1 [-3  5  3] 6  7       5
     * // 1  3  -1  -3 [5  3  6] 7       6
     * // 1  3  -1  -3  5 [3  6  7]      7
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= nums.length <= 10^5
     * // -10^4 <= nums[i] <= 10^4
     * // 1 <= k <= nums.length
     * <p>
     * Related Topics 堆 Sliding Window
     */

    public int[] maxSlidingWindow(int[] nums, int k) {

        // 最直观的解法，不用任何算法。 对每一个窗口都排序，取最大

        // 稍微升级点，堆排序，每移动一个位置，调整一次堆栈，取栈顶元素。

        // 双向队列


        return queue(nums, k);
    }


    private int[] queue(int nums[], int k) {

        /**
         * 遍历数组，将 数 存放在双向队列中，并用 L,R 来标记窗口的左边界和右边界。队列中保存的并不是真的 数，
         * 而是该数值对应的数组下标位置，并且数组中的数要从大到小排序。如果当前遍历的数比队尾的值大，则需要弹出队尾值，
         * 直到队列重新满足从大到小的要求。刚开始遍历时，L 和 R 都为 0，有一个形成窗口的过程，此过程没有最大值，L 不动，R 向右移。
         * 当窗口大小形成时，L 和 R 一起向右移，每次移动时，判断队首的值的数组下标是否在 [L,R] 中，如果不在则需要弹出队首的值，当前窗口的最大值即为队首的数。
         * */

        // 还是要注意判空处理
        if (null == nums || nums.length < k) {
            return nums;
        }

        // 队首元素最大
        LinkedList<Integer> queue = new LinkedList<>();

        int[] result = new int[nums.length - k + 1];

        // 开始遍历
        for (int i = 0; i < nums.length; ++i) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            // 内嵌循环~~ 不能因为是两层循环而放弃
            // 这里保证了队列是按照大到小排序的
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }

            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }

        return result;
    }
}
