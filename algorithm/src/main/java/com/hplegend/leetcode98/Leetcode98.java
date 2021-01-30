package com.hplegend.leetcode98;

import com.hplegend.base.TreeNode;

/**
 * @author hp.he
 * @date 2021/1/30 14:38
 */
public class Leetcode98 {


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    // 特别提示： 以每一个节点作为根的子树都是二叉树。因此，不能简单的用root，左右判断，还需要加上根的限制，
    // so，最好加上最大最小，这样就更加保险一些。
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);

    }

    // root 为根的最小最大值
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {

        if (null == root) {
            return true;
        }

        if (null != min && root.val <= min.val) {
            return false;
        }

        if (null != max && root.val >= max.val) {
            return false;
        }

        return isValidBST(root.left, null, root) && isValidBST(root.right, root, null);
    }


}
