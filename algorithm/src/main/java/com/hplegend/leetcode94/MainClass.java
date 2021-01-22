package com.hplegend.leetcode94;

import com.hplegend.base.TreeNode;

import java.util.List;

/**
 * @author hp.he
 * @date 2021/1/22 18:31
 */
public class MainClass {

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


        Leetcode94 leetcode94 = new Leetcode94();
        List<Integer> ret = leetcode94.inorderTraversal(root);

        System.out.println(ret);


    }

}
