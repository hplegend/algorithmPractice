package com.hplegend.Leetcode10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hp.he
 * @date 2021/1/25 13:11
 */
public class Leetcode10 {
    private Map<String, Boolean> mem = new HashMap<>();

    public boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }

    // 采用递归的形式，解释正则表达式
    // 动归有一种基于备忘录递归的方法，这里从0-n开始递归
    // 对于字符串s和p，在sp,和pp位置上是否匹配
    public boolean dp(String s, int sp, String p, int pp) {

        // 模式窜完毕
        if (pp == p.length()) {
            return s.length() == sp;
        }

        // 这里要根据你递归的模式来写
        if (sp == s.length()) {
            // s完毕了，p还没有完毕，需要判断是否出现了 a*a*a*的模式。这种模式是可以匹配任意空串的
            if ((p.length() - pp) % 2 == 1) {
                return false;
            }

            for (; pp + 1 < p.length(); pp += 2) {
                if (p.charAt(pp + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        // mem
        String key = sp + "," + pp;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }

        boolean boolRes = false;

        // 开始递归处理了
        if (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '.') {

            // 判断下一个是否为*
            // 如果为*，那么考虑匹配或者不匹配
            // 需要注意，这里用的是逆向递归，而不是正常的递归，需要注意一下。这个在动规里面会经常用，逆向递归。。。
            if (pp < p.length() - 1 && p.charAt(pp + 1) == '*') {
                boolRes = dp(s, sp, p, pp + 2) // *前面一个匹配不上
                        || dp(s, sp + 1, p, pp); // *前面匹配上
            } else {
                boolRes = dp(s, sp + 1, p, pp + 1);
            }

        } else {
            if (pp < p.length() - 1 && p.charAt(pp + 1) == '*') {
                boolRes = dp(s, sp, p, pp + 2); // *前面一个匹配不上
            } else {
                boolRes = false;
            }
        }
        mem.put(key, boolRes);
        return boolRes;
    }

    public boolean dp(String s, String p) {
        // 定义备忘录
        boolean[][] mem = new boolean[s.length() + 1][p.length() + 1];

        // 第一边界条件（穷举开始的条件）
        mem[0][0] = true;

        // s.i = 0, mem[i][0] = false;
        for (int sItr = 1; sItr <= s.length(); sItr++) {
            mem[sItr][0] = false;
        }

        // 开始穷举
        for (int sItr = 1; sItr <= s.length(); sItr++) {

            for (int pItr = 1; pItr <= p.length(); pItr++) {

                if (s.charAt(sItr - 1) == p.charAt(pItr - 1)) {
                    // 这种情况就是数字
                    mem[sItr][pItr] = mem[sItr - 1][pItr - 1];
                } else {
                    if (p.charAt(pItr - 1) == '.') {
                        mem[sItr][pItr] = mem[sItr - 1][pItr - 1];
                    } else {
                        if (p.charAt(pItr - 1) == '*') {
                            if (pItr < 3) {
                                mem[sItr][pItr] = true;
                                continue;
                            }

                            if (p.charAt(pItr - 2) == s.charAt(sItr - 1)) {
                                mem[sItr][pItr] = mem[sItr - 1][pItr];
                            } else if (p.charAt(pItr - 2) == '.') {
                                mem[sItr][pItr] = mem[sItr - 1][pItr];
                            } else {
                                mem[sItr][pItr] = mem[sItr][pItr - 3];
                            }
                        }
                    }
                }
            }
        }

        return mem[s.length()][p.length()];
    }



   /* public boolean dp(String s, String p) {
        // 定义备忘录
        boolean[][] mem = new boolean[s.length() + 1][p.length() + 1];

        // 第一边界条件（穷举开始的条件）
        mem[0][0] = true;

        // s.i = 0, mem[i][0] = false;
        for (int sItr = 1; sItr <= s.length(); sItr++) {
            mem[sItr][0] = false;
        }

        // 开始穷举
        for (int sItr = 1; sItr <= s.length(); sItr++) {

            for (int pItr = 1; pItr <= p.length(); pItr++) {

                if (s.charAt(sItr - 1) == p.charAt(pItr - 1)) {
                    // 这种情况就是数字
                    mem[sItr][pItr] = mem[sItr - 1][pItr - 1];
                } else {
                    if (p.charAt(pItr - 1) == '.') {
                        mem[sItr][pItr] = mem[sItr - 1][pItr - 1];
                    } else {
                        if (p.charAt(pItr - 1) == '*') {
                            if (pItr < 3) {
                                mem[sItr][pItr] = true;
                                continue;
                            }

                            if (p.charAt(pItr - 2) == s.charAt(sItr - 1)) {
                                mem[sItr][pItr] = mem[sItr - 1][pItr];
                            } else if (p.charAt(pItr - 2) == '.') {
                                mem[sItr][pItr] = mem[sItr-1][pItr];
                            } else {
                                mem[sItr][pItr] = mem[sItr][pItr - 3];
                            }
                        }
                    }
                }
            }
        }

        return mem[s.length()][p.length()];
    }
*/
}
