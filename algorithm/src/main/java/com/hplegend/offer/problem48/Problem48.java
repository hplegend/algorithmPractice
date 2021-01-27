package com.hplegend.offer.problem48;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hp.he
 * @date 2021/1/26 20:15
 */
public class Problem48 {

    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    // 记录以每一个字符结尾的最长不重复字符串
    // 三种情况：1、i<0, 默认值1
    // 2、设当前j的最近一次出现为i，如果j-1的最长子串长度小于j-i, 也就是说j的字符不在j-1的最长里面，那么可以加上j
    // 3、设当前j的最近一次出现为i，如果j-1的最长子串长度大于j-i，也就是说j的支付已经在j-1的最长里面了，那么j的最长就是j-i(这里比较困惑，但是前提是所有的子问题一定是最优，否则就会有问题)

    public int lengthOfLongestSubstring(String s) {
        //用于记录最早出现，如果没有出现，那么就是-1.
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        // 最大值记录
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }


}
