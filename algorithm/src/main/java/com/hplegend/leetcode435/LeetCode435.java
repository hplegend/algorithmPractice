package com.hplegend.leetcode435;


//Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping（不相互重叠）.
//
//
//
//
//
//
// Example 1:
//
//
//Input: [[1,2],[2,3],[3,4],[1,3]]
//Output: 1
//Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
//
//
// Example 2:
//
//
//Input: [[1,2],[1,2],[1,2]]
//Output: 2
//Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
//
//
// Example 3:
//
//
//Input: [[1,2],[2,3]]
//Output: 0
//Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
//
// [[1,4],[2,3],[3,4]]
// ouput: 1
//
// [[1,4],[2,5],[5,6]]
// Note:
//
//
// You may assume the interval's end point is always bigger than its start point.
// Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
//
// Related Topics Greedy


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hp.he
 * @date 2019/11/19 12:28
 */
public class LeetCode435 {


    /**
     * 解题一：
     * 对区间按照开始排序；
     * 一轮遍历，剔除跨区间且连续的
     */


    public int eraseOverlapIntervals(int[][] intervals) {

        // sort
        if (null == intervals) {
            return 0;
        }

        int num = intervals.length;
        if (0 == num) {
            return 0;
        }
        Arrays.sort(intervals, intervelComp);

        for (int[] var : intervals) {
            System.out.println(var[0] + "_" + var[1]);
        }

        System.out.println(num);
        System.out.println("------------------");
        // remove
        int cnt = 0;
        int[] base = intervals[0];
        for (int in = 1; in < intervals.length; ++in) {
            int[] cur = intervals[in];
            // 后面的嵌入前一个的中间
            if (cur[0] < base[1]) {
                cnt++;
                continue;
            }

            // 前后重叠
            if (cur[0] == base[0] && cur[1] == base[1]) {
                cnt++;
                continue;
            }
            System.out.println(cur[0] + "_" + cur[1]);
            base = cur;
        }

        return cnt;
    }


    public Comparator intervelComp = new Comparator<int[]>() {
        @Override
        public int compare(int[] first, int[] second) {
            // each element is interval with length = two
            // sort according to start
            // equal, then two

            if (null == first && null == second) {
                return 0;
            }

            if (null == first && null != second) {
                return 1;
            }

            if (null != first && null == second) {
                return -1;
            }

            if (first[0] < second[0]) {
                return -1;
            }

            if (first[0] > second[0]) {
                return 1;
            }

            // 等于

            if (first[1] < second[1]) {
                return -1;
            }

            if (first[1] > second[1]) {
                return 1;
            }
            return 0;
        }
    };


}
