package com.hplegend.leetcode43;

/**
 * @author hp.he
 * @date 2021/2/5 21:49
 */
public class Leetcode43 {

    // 字符串乘法，普通的乘法
    public String multiply(String num1, String num2) {

        if (num1 == null || num1.length() == 0) {
            return num2;
        }

        if (num2 == null || num2.length() == 0) {
            return num1;
        }


        StringBuilder tmpFinalRet = new StringBuilder();
        for (int i = 0; i < num1.length() + num2.length(); ++i) {
            tmpFinalRet.append('0');
        }

        // 初始化
        String fianlAns = tmpFinalRet.toString();

        for (int first = num2.length() - 1; first >= 0; --first) {
            //
            char multiNum = num2.charAt(first);
            String singleAns = multiplyOne(num1, multiNum, num2.length() - 1 - first);

            fianlAns = addTwo(fianlAns, singleAns);
        }

        // remove 前面的空白

        int zeroPadPos = 0;
        for (int i = 0; i < fianlAns.length(); ++i) {
            if (fianlAns.charAt(i) == '0') {
                zeroPadPos++;
            } else {
                break;
            }
        }

        fianlAns = zeroPadPos>0 ? fianlAns.substring(zeroPadPos) : fianlAns;

        return fianlAns;
    }


    public String multiplyOne(String num, char singleNum, int appendZero) {

        StringBuilder sb = new StringBuilder();
        for (int apd = 0; apd < appendZero; ++apd) {
            sb.append('0');
        }

        int promotion = 0;
        for (int pos = num.length() - 1; pos >= 0; --pos) {

            int x = num.charAt(pos) - '0';
            int y = singleNum - '0';

            int ansTmp = x * y + promotion;
            promotion = ansTmp / 10;
            int remain = ansTmp % 10;
            sb.append(remain);
        }

        if (promotion != 0) {
            sb.append(promotion);
        }

        return sb.reverse().toString();
    }

    public String addTwo(String one, String two) {
        StringBuilder sb = new StringBuilder();

        // 类似于小merge
        int oneLen = one.length() - 1;
        int twoLen = two.length() - 1;


        int promotion = 0;
        while (oneLen >= 0 && twoLen >= 0) {

            int tmpAns = (one.charAt(oneLen) - '0') + (two.charAt(twoLen) - '0') + promotion;
            promotion = tmpAns / 10;
            tmpAns = tmpAns % 10;

            sb.append(tmpAns);
            oneLen--;
            twoLen--;
        }

        if (oneLen != 0) {
            sb.append(promotion);
        }
        if (twoLen != 0) {
            sb.append(promotion);
        }
        return sb.reverse().toString();
    }
}
