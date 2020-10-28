package com.hplegend.leetcode344;

/**
 * @author hp.he
 * @date 2020/10/28 22:33
 */
public class MainTest {

    public static void main(String[] args) {
        Leetcode344 leetcode344 = new Leetcode344();

        char[] arr = new char[]{'s', 'h', 'n','7','8'};
        leetcode344.reverseString(arr);

        for (char v : arr) {
            System.out.print(v + ", ");
        }
    }

}
