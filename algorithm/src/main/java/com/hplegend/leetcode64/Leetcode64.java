package com.hplegend.leetcode64;

import java.util.Arrays;

/**
 * @author hp.he
 * @date 2021/1/25 17:28
 */
public class Leetcode64 {

    /**
     * //给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * //
     * // 说明：每次只能向下或者向右移动一步。
     * //
     * //
     * //
     * // 示例 1：
     * //
     * //
     * //输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * //输出：7
     * //解释：因为路径 1→3→1→1→1 的总和最小。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：grid = [[1,2,3],[4,5,6]]
     * //输出：12
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // m == grid.length
     * // n == grid[i].length
     * // 1 <= m, n <= 200
     * // 0 <= grid[i][j] <= 100
     * //
     * // Related Topics 数组 动态规划
     */

    // 每次只能向下或者向右移动一步 降低了搜索的空间大小
    // 思路1，穷举所有的，然后找最小的，这里采用深度优先的方式+回溯法。(用栈记录需要变量的节点)
    // 思路2，穷举+备忘录（动归）。 动归的本质： 有备忘录的穷举，因此，设计合适的穷举方式很重要，而合适的穷举也正好与状态转移方程相吻合。
    // 递归+备忘录。不要总想着迭代，先简单的能解决了问题
    // 递归的核心就是要抽取良好的模式，以及递归的出口

    int[][] mem;

    public int minPathSum(int[][] grid) {
        int col = grid.length;
        int row = grid[0].length;
        mem = new int[col][row];

        for (int[] ele : grid) {
            Arrays.fill(ele, -1);
        }

        return dp(grid, col - 1, row - 1);
    }

    // 递归的入口模式方法
    // 递归的魅力
    public int dp(int[][] grid, int posx, int posy) {
        // 递归的结束条件
        if (posx == 0 && posy == 0) {
            return grid[0][0];
        }

        if (posx < 0 || posy < 0) {
            return Integer.MAX_VALUE;
        }

        if (-1 != mem[posx][posy]) {
            return mem[posx][posy];
        }

        int minPath = Math.min(dp(grid, posx - 1, posy), dp(grid, posx, posy - 1)) + grid[posx][posy];
        mem[posx][posy] = minPath;
        return minPath;
    }
}
