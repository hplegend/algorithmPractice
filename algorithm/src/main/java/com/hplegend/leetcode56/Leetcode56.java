package com.hplegend.leetcode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author hp.he
 * @date 2021/2/3 11:54
 */
public class Leetcode56 {

    public int[][] merge(int[][] intervals) {
        List<int[]> ret = new ArrayList<>();
        Arrays.sort(intervals, arryCom);


        for (int i = 0; i < intervals.length; ++i) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            if (ret.size() == 0) {
                ret.add(intervals[i]);
                continue;
            }

            int lastRMast = ret.get(ret.size() - 1)[1];

            if (left > lastRMast) {
                ret.add(intervals[i]);
                continue;
            }


            if (lastRMast <= right) {
                ret.get(ret.size() - 1)[1] = right;
            }
        }
        return ret.toArray(new int[][]{});
    }


    public Comparator<int[]> arryCom = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            // 强制保证int[]的大小为2
            return o1[0] - o2[0];
        }
    };


}
