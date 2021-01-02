package com.hplegend.leetcode226;

import com.hplegend.base.TreeNode;

/**
 * @author hp.he
 * @date 2021/1/2 12:18
 */
public class Leetcode226 {


    /**
     * //翻转一棵二叉树。
     * //
     * // 示例：
     * //
     * // 输入：
     * //
     * //      4
     * //   /   \
     * //  2     7
     * // / \   / \
     * //1   3 6   9
     * //
     * // 输出：
     * //
     * //      4
     * //   /   \
     * //  7     2
     * // / \   / \
     * //9   6 3   1
     */

    // 思路：递归
    public TreeNode invertTree(TreeNode root) {

        // 递归的出口

        if (null == root) {
            return null;
        }

        TreeNode leftRoot = invertTree(root.left);
        TreeNode rightRoot = invertTree(root.right);

        if (leftRoot == null && rightRoot == null) {
            return root;
        }

        if (leftRoot == null) {
            root.left = root.right;
            root.right = null;
            return root;
        }

        if (rightRoot == null) {
            root.right = root.left;
            root.left = null;
            return root;
        }


        // 交互左右
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }


}
