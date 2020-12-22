package com.hplegend.leetcode7;

/**
 * @author hp.he
 * @date 2020/11/11 17:50
 */
public class Leetcode7 {

    public int reverse(int x) {
        // 反转，符号位不变
        // 反转，采用数学公式反转。 /10 或者 %10
        // 溢出判断
        // 判断已经生成的数字，与 （INT_MAX_VALUE / 10） 的大小：
        // 如果大于，则在继续*10肯定会移除；
        // 如果等于，判断余数与INT_MAX_VALUE%10的余数大小，对于整数，要求余数小于INT_MAX_VALUE%10，如果大于则移除； 对于负数，要求余数 大于 INT_MAX_VALUE%10，如果小于则移除


        int rev = 0;

        while (x != 0) {
            // 作为尾数添加上
            int newEle = x % 10;
            x = x / 10;


            // 对于正数：要求+newEle要小于 MAX_VALUE的尾数
            if (rev > (Integer.MAX_VALUE / 10) || (rev == Integer.MAX_VALUE / 10 && newEle > Integer.MAX_VALUE % 10)) {
                rev = 0;
                break;
            }

            // 对于正数：要求+newEle要大于 MAX_VALUE的尾数
            if (rev < (Integer.MIN_VALUE / 10) || (rev == Integer.MIN_VALUE / 10 && newEle < Integer.MIN_VALUE % 10)) {
                rev = 0;
                break;
            }
            rev = rev * 10 + newEle;
        }

        return rev;
    }

}
