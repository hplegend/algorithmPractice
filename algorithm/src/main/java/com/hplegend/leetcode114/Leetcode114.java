package com.hplegend.leetcode114;

import com.hplegend.base.TreeNode;

/**
 * @author hp.he
 * @date 2021/1/3 11:38
 */
public class Leetcode114 {

    public void flatten(TreeNode root) {

        // 递归
        // 分别张开左右，然后把右侧连接到左侧

        if (null == root) {
            return;
        }


        flatten(root.left);
        flatten(root.right);

        //
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 替换root节点
        root.left = null;
        root.right = left;

        // 拼接 right 到left的最后一个节点
        // 实际上遍历的是左节点
        TreeNode tmp = root.right;
        while (tmp.right != null) {
            tmp = tmp.right;
        }

        tmp.right = right;

    }

}
