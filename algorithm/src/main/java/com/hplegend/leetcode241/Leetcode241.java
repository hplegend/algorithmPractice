package com.hplegend.leetcode241;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hp.he
 * @date 2020/12/2 13:28
 */
public class Leetcode241 {
    //给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 *
//
// 示例 1:
//
// 输入: "2-1-1"
//输出: [0, 2]
//解释:
//((2-1)-1) = 0
//(2-(1-1)) = 2
//
// 示例 2:
//
// 输入: "2*3-4*5"
//输出: [-34, -14, -10, -10, 10]
//解释:
//(2*(3-(4*5))) = -34
//((2*3)-(4*5)) = -14
//((2*(3-4))*5) = -10
//(2*((3-4)*5)) = -10
//(((2*3)-4)*5) = 10

    public List<Integer> diffWaysToCompute(final String input) {

        // 分治递归+穷举
        // 优化方法：备忘录
        List<Integer> ret = new ArrayList<>();

        for (int index = 0; index < input.length(); ++index) {
            if ('-' == input.charAt(index) || '+' == input.charAt(index) || '*' == input.charAt(index)) {

                String leftInput = input.substring(0, index);
                String rightInput = input.substring(index + 1);

                List<Integer> letValue = diffWaysToCompute(leftInput);
                List<Integer> rightValue = diffWaysToCompute(rightInput);

                // 做排列组合
                // 任意一个左边的值，都能与右边运算
                // 这就全排列
                for (int left : letValue) {
                    for (int right : rightValue) {
                        switch (input.charAt(index)) {
                            case '-':
                                ret.add(left - right);
                                break;
                            case '+':
                                ret.add(left + right);
                                break;
                            case '*':
                                ret.add(left * right);
                                break;
                            default:
                                break;

                        }
                    }
                }
            }
        }

        // 特别注意这里的递归结束条件不一样，在末尾
        if (ret.size() == 0) {
            ret.add(Integer.parseInt(input));
        }

        return ret;
    }


}

