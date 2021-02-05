package com.hplegend.leetcode51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hp.he
 * @date 2021/2/3 12:49
 */
public class Leetcode51 {

    List<List<String>> fialRet = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[][] chess = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(chess[i], 0);
        }

        List<String> pos = new ArrayList<>(n);
        nQuen(chess, 1, n, pos);
        return fialRet;
    }

    // 最后的pos需要copy一下
    private void nQuen(int[][] chess, int curRow, int totalQuen, List<String> pos) {

        // 已经结束了一种
        if (curRow > totalQuen) {
            // copy 存储
            String[] copyArr = Arrays.copyOf(pos.toArray(new String[0]), pos.size());

            List<String> copyList = new ArrayList<>();
            Collections.addAll(copyList,copyArr);
            fialRet.add(copyList);
            return;
        }


        for (int i = 0; i < totalQuen; ++i) {
            // 判断合法性
            boolean valid = isSatisfy(chess, curRow, i);
            if (valid) {
                pos.set(i, "G");
                nQuen(chess, curRow + 1, totalQuen, pos);
                pos.set(i, " ");
            } else {
                pos.set(i, " ");
            }
        }


    }

    private static boolean isSatisfy(int[][] chess, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 1) { // 同一列的上方元素
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) { // 左上方斜对角线
            if (chess[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < chess.length; i--, j++) { // 右上方斜对角线
            if (chess[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
