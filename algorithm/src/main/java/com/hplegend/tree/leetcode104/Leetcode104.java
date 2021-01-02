package com.hplegend.tree.leetcode104;

import com.hplegend.base.TreeNode;

/**
 * @author hp.he
 * @date 2020/12/22 9:34
 */
public class Leetcode104 {

    /**
     * *     int val;
     * *     TreeNode left;
     * *     TreeNode right;
     * *     TreeNode() {}
     * *     TreeNode(int val) { this.val = val; }
     * *     TreeNode(int val, TreeNode left, TreeNode right) {
     * *         this.val = val;
     * *         this.left = left;
     * *         this.right = right;
     * *     }
     */

    // 递归
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int legfDepth = maxDepth(root.left);
        int rightDepght = maxDepth(root.right);

        return legfDepth > rightDepght ? legfDepth + 1 : rightDepght + 1;
    }


}
