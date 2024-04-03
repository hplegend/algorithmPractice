package com.hplegend.leetcode01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Leetcode03 {

    public int[] twoSum(int[] nums, int target) {
        int[] indexArr = new int[2];
        Map<Integer, List<Integer>> numIndexMap = new HashMap<>();
        AtomicInteger curse = new AtomicInteger(0);
        for (int num : nums) {
            if (numIndexMap.containsKey(num)) {
                numIndexMap.get(num).add(curse.getAndAdd(1));
                continue;
            }
            List<Integer> value = new ArrayList<>();
            value.add(curse.getAndAdd(1));
            numIndexMap.put(num, value);
        }

        for (Map.Entry<Integer, List<Integer>> entry : numIndexMap.entrySet()) {
            int minus = target - entry.getKey();
            if (numIndexMap.containsKey(minus)) {
                if (minus == entry.getKey()) {
                    if (numIndexMap.get(minus).size() > 1) {
                        indexArr[0] = entry.getValue().get(0);
                        indexArr[1] = entry.getValue().get(1);
                    }
                } else {

                    indexArr[0] = entry.getValue().get(0);
                    indexArr[1] = numIndexMap.get(minus).get(0);

                }
            }
        }

        if (indexArr[1] < indexArr[0]) {
            int tmp = indexArr[1];
            indexArr[1] = indexArr[0];
            indexArr[0] = tmp;
        }
        return indexArr;
    }

    public static void main(String[] args) {

        int num[] = new int[]{2, 7, 11, 15, 15, 15, 55};
        Leetcode03 leetcode03 = new Leetcode03();
        int ret[] = leetcode03.twoSum(num, 30);
        System.out.println(ret[0] + "_" + ret[1]);

    }
}
