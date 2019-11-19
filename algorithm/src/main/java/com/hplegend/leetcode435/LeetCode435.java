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
     * 对区间按照结束排序；
     * 一轮遍历，
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

        // remove
        int cnt = 1;
        int[] base = intervals[0];

        // 寻找最大连接的
        // 总数减去即可得到最小删除数
        // trick : 只是不重叠，允许断开
        for (int in = 1; in < intervals.length; ++in) {
            int[] cur = intervals[in];
            if (cur[0] >= base[1]) {
                cnt++;
                base = intervals[in];
            }
        }

        return intervals.length - cnt;
    }


    /**
     * 按照结束区间排序，从小到大拍序
     */
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
