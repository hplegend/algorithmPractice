package com.hplegend.leetcode13;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hp.he
 * @date 2020/12/1 17:20
 */
public class Leetcode13 {

    public int romanToInt(String s) {
        // map
        Map<String, Integer> map = new HashMap<>(16);

        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        // 两位优先
        int ans = 0;
        for (int curLen = 0; curLen < s.length(); ) {

            String twoSub = s.substring(curLen, curLen + 2);
            String oneSub = s.substring(curLen, curLen + 1);

            if (curLen + 1 < s.length() && map.containsKey(twoSub)) {
                ans += map.get(twoSub);
                curLen = curLen + 2;
            } else {
                ans += map.get(oneSub);
                curLen = curLen + 1;
            }
        }

        return ans;
    }
}
