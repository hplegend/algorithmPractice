package com.hplegend.leetcode101;

import com.hplegend.leetcode101.TreeNode;

/**
 * @author hp.he
 * @date 2020/12/8 16:45
 */
public class MainTestClass {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        TreeNode left_1 = new TreeNode(2);
        TreeNode right_1 = new TreeNode(2);

        root.left = left_1;
        root.right = right_1;


        TreeNode left_1_l = new TreeNode(3);
        TreeNode left_1_r = new TreeNode(4);
        left_1.left = left_1_l;
        left_1.right = null;


        TreeNode right_1_l = new TreeNode(4);
        TreeNode right_1_r = new TreeNode(5);
        right_1.left = right_1_l;
        right_1.right = null;

        Leetcode101 leetcode101 = new Leetcode101();
        System.out.println(leetcode101.isSymmetric(root));
    }
}
