package com.hplegend.leetcode226;

import com.hplegend.base.TreeLevelTransver;
import com.hplegend.base.TreeNode;

/**
 * @author hp.he
 * @date 2021/1/2 12:18
 */
public class MainTestClass {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);

        TreeNode level1L = new TreeNode(2);
        TreeNode level1R = new TreeNode(7);
        TreeNode level21L = new TreeNode(1);
        TreeNode level21R = new TreeNode(3);
        TreeNode level22L = new TreeNode(6);
        TreeNode level22R = new TreeNode(9);

        root.left = level1L;
        root.right = level1R;

        level1L.left = level21L;
        level1L.right = level21R;

        level1R.left = level22L;
        level1R.right = level22R;


        Leetcode226 leetcode226 = new Leetcode226();

        TreeNode newRoot = leetcode226.invertTree(root);

        // 层序遍历
        TreeLevelTransver.doLevenTranser(newRoot);




    }

}
