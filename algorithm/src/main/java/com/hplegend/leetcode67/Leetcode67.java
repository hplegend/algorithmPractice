package com.hplegend.leetcode67;

/**
 * @author hp.he
 * @date 2020/10/10 17:21
 */
public class Leetcode67 {


    /**
     * a="11", b="1"
     * <p>
     * sum = a+ b = "100"
     * <p>
     * 时间复杂度肯定是一轮for循环。
     */

    String binarySum(String a, String b) {
        // 普通的按位运算，计算敬进位
        // 初始进位为0
        int promote = 0;

        int firstLen = a.length();
        int secondLen = b.length();
        StringBuilder sb = new StringBuilder();

        for (firstLen = firstLen - 1, secondLen = secondLen - 1; firstLen >= 0 || secondLen >= 0; firstLen--, secondLen--) {
            int firstValue = firstLen >= 0 ? Integer.parseInt("" + a.charAt(firstLen)) : 0;
            int secondValue = secondLen >= 0 ? Integer.parseInt("" + b.charAt(secondLen)) : 0;
            int sum = firstValue + secondValue + promote;
            // 进位每次使用后，必须要清零
            promote = 0;
            if (sum >= 2) {
                promote = sum / 2;
                sum = sum % 2;
            }

            sb.insert(0, sum);
        }

        if (promote > 0) {
            sb.insert(0, '1');
        }

        return sb.toString();
    }


}
