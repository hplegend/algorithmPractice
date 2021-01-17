package com.hplegend.leetcode1232;

/**
 * @author hp.he
 * @date 2021/1/17 23:03
 */
public class Leetcode1232 {

    public boolean checkStraightLine(int[][] coordinates) {

        int pointLen = coordinates.length;


        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];

        int xn = coordinates[pointLen - 1][0];
        int yn = coordinates[pointLen - 1][1];


        for (int i = 1; i < pointLen - 1; ++i) {
            int xi = coordinates[i][0];
            int yi = coordinates[i][1];

            if ((x0 - xi) * (yi - yn) != (xi - xn) * (y0 - yi)) {
                return false;
            }

        }
        return true;
    }


}
