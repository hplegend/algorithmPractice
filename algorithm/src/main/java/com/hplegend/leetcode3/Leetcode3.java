package com.hplegend.leetcode3;

import java.util.HashMap;

/**
 * @author hp.he
 * @date 2021/2/5 17:33
 */
public class Leetcode3 {


    // 滑动窗口，map就是维护的窗口
    // max类u就是维护的最大值
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            // 对于任何一个新加入的元素，判断其是否再串口中
            // 寻找新的窗口位置
            // 这里要特别注意，主关注当前的元素，其他的不要管。如，发现重复，那么从重复的地方开始即可，而不需要关注其他的是否有重复。
            // 按照滑动串口的定义，一定是没有重复的，因为每一次新进入一个元素，都做了判断。
            if (map.containsKey(s.charAt(i))) {

                // 找新的位置
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }

            // 放入元素
            map.put(s.charAt(i), i);

            // 判断大小，i-left+1，其实因为下标
            max = Math.max(max, i - left + 1);
        }
        return max;

    }

}
