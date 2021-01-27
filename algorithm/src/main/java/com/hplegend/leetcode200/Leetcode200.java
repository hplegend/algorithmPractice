package com.hplegend.leetcode200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hp.he
 * @date 2021/1/26 20:37
 */
public class Leetcode200 {

    /* public int numIslands(char[][] grid) {
         int rowLen = grid.length;
         int colLen = grid[0].length;


         int firstNum = 0;

         for (int row = 0; row < rowLen; ++row) {
             for (int col = 0; col < colLen; ++col) {
                 if (grid[row][col] == '1') {
                     firstNum += 1;
                     dfs(grid, row, col);
                 }
             }
         }

         return firstNum;
     }
 */
    // 深度遍历，有点带递归的
    void dfs(char[][] grid, int row, int col) {

        int rowLen = grid.length;
        int colLen = grid[0].length;

        if (row >= rowLen || col >= colLen) {
            return;
        }

        if (row < 0 || col < 0) {
            return;
        }

        if (grid[row][col] == '0') {
            return;
        }

        // 不回退
        grid[row][col] = '0';

        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
    }

    public int numIslands(char[][] grid) {
        return bfs(grid);
    }


    // 深度遍历，有点带递归的
    int bfs(char[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }

        int rowLen = grid.length;
        int colLen = grid[0].length;

        int firstNum = 0;

        for (int row = 0; row < rowLen; ++row) {
            for (int col = 0; col < colLen; ++col) {

                if (grid[row][col] == '0') {
                    continue;
                }

                firstNum += 1;
                Queue<Integer> posQueue = new LinkedList<>();

                posQueue.add(row * colLen + col);
                while (!posQueue.isEmpty()) {
                    int pos = posQueue.remove();

                    int tmpRow = pos / colLen;
                    int tmpCol = pos % colLen;

                    // 邻居入队列
                    if (tmpRow - 1 >= 0 && grid[tmpRow - 1][tmpCol] == '1') {
                        posQueue.add((tmpRow - 1) * colLen + tmpCol);
                        grid[tmpRow - 1][tmpCol] = '0';
                    }


                    if (tmpRow + 1 < rowLen && grid[tmpRow + 1][tmpCol] == '1') {
                        posQueue.add((tmpRow + 1) * colLen + tmpCol);
                        grid[tmpRow + 1][tmpCol] = '0';
                    }


                    if (tmpCol - 1 > 0 && grid[tmpRow][tmpCol - 1] == '1') {
                        posQueue.add(tmpRow * colLen + tmpCol - 1);
                        grid[tmpRow - 1][tmpCol] = '0';
                    }


                    if (tmpCol + 1 < colLen && grid[tmpRow][tmpCol + 1] == '1') {
                        posQueue.add((tmpRow) * colLen + tmpCol + 1);
                        grid[tmpRow][tmpCol - 1] = '0';
                    }

                }

            }
        }


        return firstNum;
    }


}
