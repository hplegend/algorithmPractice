package com.ys;


import java.util.Stack;

public class Search {


    class Position {
        int col;
        int row;
        int originValue;

        Position(int col, int row, int value) {
            this.col = col;
            this.row = row;
            this.originValue = value;
        }

    }

    // 贪心选择
    int doStackSearch(int[][] searchSpace) {

        int sumPos = -1;

        int curPosCol = 0;
        int curPosRow = 0;
        Stack<Position> next = new Stack<>();
        next.push(new Position(curPosCol, curPosRow, searchSpace[curPosRow][curPosCol]));

        int rowLen = searchSpace.length;
        int colLen = searchSpace[0].length;

        // 标记该节点访问

        while (!next.isEmpty()) {
            Position curPos = next.pop();
            curPosCol = curPos.col;
            curPosRow = curPos.row;

            searchSpace[curPosRow][curPosCol] = 1;

            // 顺时针的方向加入
            // 右，下，左，上
            int minValue = Integer.MAX_VALUE;
            int minCol = 0;
            int minRow = 0;
            if (curPosCol + 1 < colLen
                    && isBlocked(curPosCol + 1, curPosRow, searchSpace) && isSearched(curPosCol + 1, curPosRow, searchSpace)) {
                if (searchSpace[curPosRow][curPosCol + 1] < minValue) {
                    minValue = searchSpace[curPosRow][curPosCol + 1];
                    minCol = curPosCol + 1;
                    minRow = curPosRow;
                }
            }
            if (curPosRow + 1 < rowLen
                    && isBlocked(curPosCol, curPosRow + 1, searchSpace) && isSearched(curPosCol, curPosRow + 1, searchSpace)) {
                if (searchSpace[curPosRow + 1][curPosCol] < minValue) {
                    minValue = searchSpace[curPosRow + 1][curPosCol];
                    minCol = curPosCol;
                    minRow = curPosRow + 1;
                }
            }
            if (curPosCol - 1 > 0
                    && isBlocked(curPosCol - 1, curPosRow, searchSpace) && isSearched(curPosCol - 1, curPosRow, searchSpace)) {
                if (searchSpace[curPosRow][curPosCol - 1] < minValue) {
                    minValue = searchSpace[curPosRow][curPosCol - 1];
                    minCol = curPosCol - 1;
                    minRow = curPosRow;
                }
            }
            if (curPosRow - 1 > 0
                    && isBlocked(curPosCol, curPosRow - 1, searchSpace) && isSearched(curPosCol, curPosRow - 1, searchSpace)) {
                if (searchSpace[curPosRow - 1][curPosCol] < minValue) {
                    minValue = searchSpace[curPosRow - 1][curPosCol];
                    minCol = curPosCol + 1;
                    minRow = curPosRow;
                }
            }

            if (minValue == Integer.MAX_VALUE) {
                // 判断是否还有剩余的
                if (isRemainWealth(searchSpace)) {
                    sumPos = -1;
                }

            } else {
                searchSpace[minRow][minCol] = 1;
                next.push(new Position(minCol, minRow, minValue));
                sumPos++;
            }
        }

        return sumPos;
    }


    private boolean isSearched(int col, int row, int[][] searchSpace) {
        return searchSpace[row][col] == 1;
    }

    private boolean isBlocked(int col, int row, int[][] searchSpace) {
        return searchSpace[row][col] == 0;
    }

    private boolean isRemainWealth(int[][] searchSpace) {
        int rowLen = searchSpace.length;
        int colLen = searchSpace[0].length;

        for (int row = 0; row < rowLen; ++row) {
            for (int col = 0; col < colLen; ++col) {
                if (searchSpace[row][col] > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
