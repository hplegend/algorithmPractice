package com.hplegend.ptr.leetcode11;

/**
 * @author hp.he
 * @date 2020/10/9 17:23
 */
public class MainTestClass {

    public static void main(String[] args) {
        Leetcode11 leetcode11 = new Leetcode11();
        int[] data = new int[]{1, 4, 6, 2, 10, 4, 8, 3, 2};
        int ret = leetcode11.maxAreaBaoli(data);
        System.out.println(ret);

        ret = leetcode11.maxArea2(data);
        System.out.println(ret);

        ret = leetcode11.maxArea3(data);
        System.out.println(ret);
    }
}
